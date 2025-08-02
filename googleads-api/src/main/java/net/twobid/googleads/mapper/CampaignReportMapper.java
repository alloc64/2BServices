/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.mapper;

import com.google.ads.googleads.v16.resources.Campaign;
import com.google.ads.googleads.v16.resources.UserLocationView;
import com.google.ads.googleads.v16.services.GoogleAdsRow;
import net.twobid.billing.api.CoreApi;
import net.twobid.core.api.model.FindCurrencyRatesByDatesRequest;
import net.twobid.googleads.dto.CampaignReportDto;
import net.twobid.googleads.query.CountryCriterion;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static net.twobid.shared.utils.DateUtils.YYYY_MM_DD;

@Component
@Mapper(componentModel = "spring")
public abstract class CampaignReportMapper {
    private static final Pattern PACKAGE_NAME_PATTERN = Pattern.compile("([A-Za-z]{1}[A-Za-z\\d_]*\\.)+[A-Za-z][A-Za-z\\d_]*$");

    @Autowired
    private CoreApi coreApi;

    static {
        CountryCriterion.initialize();
    }

    @Mappings({
            @Mapping(target = "date", expression = "java(java.time.LocalDate.parse(report.getSegments().getDate(), net.twobid.shared.utils.DateUtils.YYYY_MM_DD))"),
            @Mapping(target = "customerId", source = "customer.id"),
            @Mapping(target = "campaignId", source = "campaign.id"),
            @Mapping(target = "packageName", expression = "java(extractPackageName(report))"),
            @Mapping(target = "name", source = "campaign.name"),
            @Mapping(target = "country", expression = "java(resolveCountry(report.getUserLocationView()))"),
            @Mapping(target = "impressions", source = "metrics.impressions"),
            @Mapping(target = "clicks", source = "metrics.clicks"),
            @Mapping(target = "ctr", source = "metrics.ctr"),
            @Mapping(target = "conversions", source = "metrics.conversions"),
            @Mapping(target = "conversionValue", source = "metrics.conversionsValue"),
            @Mapping(target = "viewThroughConversions", source = "metrics.viewThroughConversions"),
            @Mapping(target = "conversionRate", expression = "java(report.getMetrics().getClicks() == 0 ? 0 : report.getMetrics().getConversions() / report.getMetrics().getClicks())"),
            @Mapping(target = "cost", expression = "java(report.getMetrics().getCostMicros() / 1000000f)"),
            @Mapping(target = "currency", source = "customer.currencyCode"),
    })
    public abstract CampaignReportDto resolve(GoogleAdsRow report);

    public List<CampaignReportDto> resolve(Iterator<GoogleAdsRow> report) {
        List<CampaignReportDto> result = new ArrayList<>();

        while (report.hasNext())
            result.add(resolve(report.next()));

        if (!result.isEmpty()) {
            Set<LocalDate> dates = result.stream()
                    .map(CampaignReportDto::getDate)
                    .collect(Collectors.toSet());

            String currencyCode = result.get(0).getCurrency();
            if (StringUtils.isEmpty(currencyCode))
                throw new IllegalStateException("Currency code is empty");

            Map<LocalDate, Double> currencyRates = coreApi.currencyRate()
                    .findByDates(new FindCurrencyRatesByDatesRequest().dates(new ArrayList<>(dates)), currencyCode)
                    .blockingSingle()
                    .getCurrencyRates()
                    .entrySet()
                    .stream()
                    .filter(x -> x.getValue() != null)
                    .map(x -> Map.entry(LocalDate.parse(x.getKey(), YYYY_MM_DD), x.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            for(CampaignReportDto entry : result) {
                Double rate = currencyRates.get(entry.getDate());

                entry.setConversionValue(entry.getConversionValue() / rate);
                entry.setCost(entry.getCost() / rate);
            }
        }

        return result;
    }

    @Named("rootNames")
    String extractPackageName(GoogleAdsRow report) {
        Campaign campaign = report.getCampaign();

        String packageName = report.getCampaign().getAppCampaignSetting().getAppId();

        if(!StringUtils.isEmpty(packageName))
            return packageName;

        String campaignName = campaign.getName();

        if (StringUtils.isEmpty(campaignName))
            return null;

        Matcher matcher = PACKAGE_NAME_PATTERN.matcher(campaignName);

        //TODO: extract packagename from appinfo, then fallback to this shit
        if (!matcher.find())
            return null;

        return matcher.group();
    }

    @Named("rootNames")
    String resolveCountry(UserLocationView userLocationView) {
        return userLocationView != null && userLocationView.hasCountryCriterionId()
                ? CountryCriterion.resolve(userLocationView.getCountryCriterionId()) : null;
    }
}
