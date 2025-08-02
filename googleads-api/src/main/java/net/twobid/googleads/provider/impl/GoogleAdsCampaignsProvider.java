/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.provider.impl;

import com.google.ads.googleads.lib.utils.FieldMasks;
import com.google.ads.googleads.v16.common.MaximizeConversionValue;
import com.google.ads.googleads.v16.common.MaximizeConversions;
import com.google.ads.googleads.v16.common.TargetCpa;
import com.google.ads.googleads.v16.common.TargetRoas;
import com.google.ads.googleads.v16.enums.CampaignStatusEnum;
import com.google.ads.googleads.v16.resources.*;
import com.google.ads.googleads.v16.services.CampaignOperation;
import com.google.ads.googleads.v16.services.CampaignServiceClient;
import com.google.ads.googleads.v16.services.GoogleAdsRow;
import com.google.ads.googleads.v16.services.SuggestGeoTargetConstantsRequest;
import com.google.ads.googleads.v16.utils.ResourceNames;
import lombok.RequiredArgsConstructor;
import net.twobid.googleads.dto.CampaignReportRequestDto;
import net.twobid.googleads.dto.FindAllCampaignsRequestDto;
import net.twobid.googleads.dto.LocationTargetingDto;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import net.twobid.googleads.provider.model.CampaignDetail;
import net.twobid.googleads.query.Gaql;
import net.twobid.googleads.query.QueryBuilder;
import net.twobid.shared.model.PageTokenPage;
import net.twobid.shared.model.PageTokenPageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GoogleAdsCampaignsProvider extends GoogleAdsDataProvider.ProviderAware<GoogleAdsCampaignsProvider> {
    private static final DateTimeFormatter YYYYMMDD = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final float MICROS = 1000000f;
    private final QueryBuilder campaignQuery = new QueryBuilder()
            .select(Gaql.Campaign.id,
                    Gaql.Customer.id,
                    Gaql.Campaign.name,
                    Gaql.Campaign.startDate,
                    Gaql.Campaign.endDate,
                    Gaql.Campaign.status,
                    Gaql.Campaign.campaignBudget,
                    Gaql.CampaignBudget.amountMicros,
                    Gaql.Campaign.biddingStrategyType,
                    Gaql.Campaign.targetCpaTargetCpaMicros,
                    Gaql.Campaign.maximizeConversionsTargetCpaMicros,
                    Gaql.Campaign.maximizeConversionValueTargetRoas,
                    Gaql.Campaign.targetRoasTargetRoas,
                    Gaql.Campaign.appCampaignSettingAppId,
                    Gaql.Campaign.selectiveOptimizationConversionActions,
                    Gaql.Campaign.optimizationScore,
                    Gaql.Customer.currencyCode)
            .from(Gaql.Table.campaign);

    public PageTokenPage<GoogleAdsRow> findAll(Principal principal,
                                               long customerId,
                                               FindAllCampaignsRequestDto request,
                                               PageTokenPageable pageable) throws Exception {
        return queryPaged(principal, customerId, buildFindAllQuery(customerId, request), pageable, r -> r);
    }

    public Iterator<GoogleAdsRow> findAll(Principal principal,
                                          long customerId,
                                          FindAllCampaignsRequestDto request) throws Exception {
        return query(principal, customerId, buildFindAllQuery(customerId, request));
    }

    public List<CampaignDetail> findAllTargetingLocation(Principal principal,
                                                       long customerId,
                                                       String appId,
                                                       LocationTargetingDto targeting) throws Exception {
        QueryBuilder query = new QueryBuilder()
                .select(Gaql.Campaign.id, Gaql.CampaignCriterion.locationGeoTargetConstant)
                .from(Gaql.Table.campaignCriterion)
                .where(Gaql.Campaign.appCampaignSettingAppId + " = :appId")
                .where(" AND " + Gaql.CampaignCriterion.locationGeoTargetConstant + " IN (:geoTargetConstants)")
                .withBindVariableValue("appId", "'" + appId + "'")
                .withBindVariableValue("geoTargetConstants", targeting.getGeoTargetConstants()
                        .stream()
                        .map(g -> "'%s'".formatted(g.getResourceName()))
                        .collect(Collectors.joining(","))
                );


        List<GoogleAdsRow> rows = queryList(principal, customerId, query);

        if (rows.isEmpty())
            return new ArrayList<>();

        Map<Long, List<String>> campaignIdToGeoTarget = new LinkedHashMap<>();
        Set<Long> campaignIds = new LinkedHashSet<>();
        Set<String> geoTargetConstants = new LinkedHashSet<>();

        for(GoogleAdsRow row : rows) {
            Long campaignId = row.getCampaign().getId();
            String geoTargetConstant = row.getCampaignCriterion().getLocation().getGeoTargetConstant();

            campaignIds.add(campaignId);
            geoTargetConstants.add(geoTargetConstant);
            campaignIdToGeoTarget.computeIfAbsent(campaignId, k -> new ArrayList<>()).add(geoTargetConstant);
        }

        Map<String, GeoTargetConstant> resolvedGeoTargetConstants = provider().targeting().findAll(principal,
                SuggestGeoTargetConstantsRequest.newBuilder()
                        .setGeoTargets(SuggestGeoTargetConstantsRequest.GeoTargets.newBuilder()
                                .addAllGeoTargetConstants(geoTargetConstants)
                                .build())
                        .build())
                .stream()
                .collect(Collectors.toMap(GeoTargetConstant::getResourceName, Function.identity()));

        List<GoogleAdsRow> campaignRows = new ArrayList<>();
        Iterator<GoogleAdsRow> it = findAll(principal, customerId,
                new FindAllCampaignsRequestDto()
                        .setStatus(List.of(
                                CampaignStatusEnum.CampaignStatus.ENABLED.name(),
                                CampaignStatusEnum.CampaignStatus.PAUSED.name())
                        )
                        .setCampaignIds(new ArrayList<>(campaignIds))
        );

        it.forEachRemaining(campaignRows::add);

        List<CampaignDetail> campaigns = new ArrayList<>();

        for (GoogleAdsRow campaign : campaignRows) {
            List<String> geoTargets = campaignIdToGeoTarget.get(campaign.getCampaign().getId());

            campaigns.add(new CampaignDetail()
                    .setCampaign(campaign)
                    .setLocationTargetingGeoTargetConstants(geoTargets.stream()
                            .map(resolvedGeoTargetConstants::get)
                            .collect(Collectors.toList())
                    )
            );
        }

        return campaigns;
    }

    public GoogleAdsRow findByIdFast(Principal principal, long customerId, long campaignId) throws Exception {
        QueryBuilder query = campaignQuery.clone()
                .where(Gaql.Customer.id + " = :customerId AND " + Gaql.Campaign.id + " = :campaignId")
                .withBindVariableValue("customerId", customerId)
                .withBindVariableValue("campaignId", campaignId)
                .limit(1);

        return querySingle(principal, customerId, query)
                .orElseThrow(() -> new NoSuchElementException("Campaign %s not found".formatted(campaignId)));
    }

    public CampaignDetail findById(Principal principal, long customerId, long campaignId) throws Exception {
        GoogleAdsRow row = findByIdFast(principal, customerId, campaignId);

        List<ConversionAction> conversionActions = new ArrayList<>();

        if (row.getCampaign().hasSelectiveOptimization()) {
            conversionActions = provider().conversionActions().findById(principal, customerId,
                    row.getCampaign().getSelectiveOptimization()
                            .getConversionActionsList()
                            .stream()
                            .map(a -> Long.parseLong(ConversionActionName.parse(a).getConversionActionId()))
                            .toList()
            );
        }


        return new CampaignDetail()
                .setCampaign(row)
                .setConversionActions(conversionActions)
                .setLocationTargetingGeoTargetConstants(
                        provider().targeting().findByCampaignId(principal, customerId, campaignId)
                );
    }


    public GoogleAdsRow setStatus(Principal principal,
                                  long customerId,
                                  long campaignId,
                                  CampaignStatusEnum.CampaignStatus status) throws Exception {
        createOrUpdate(principal, customerId, Campaign.newBuilder()
                .setResourceName(ResourceNames.campaign(customerId, campaignId))
                .setStatus(status)
                .build());

        return findByIdFast(principal, customerId, campaignId);
    }

    public GoogleAdsRow setBid(Principal principal, long customerId, long campaignId, double bid) throws Exception {
        Campaign campaign = findByIdFast(principal, customerId, campaignId).getCampaign();

        Campaign.Builder update = Campaign.newBuilder()
                .setId(campaignId)
                .setResourceName(campaign.getResourceName())
                .setBiddingStrategyType(campaign.getBiddingStrategyType());

        double m = provider().account().currencyRate(principal, customerId);

        switch (update.getBiddingStrategyType()) {
            case MAXIMIZE_CONVERSIONS -> update.setMaximizeConversions(MaximizeConversions.newBuilder()
                    .setTargetCpaMicros((long) (bid * m * MICROS)).build());
            case MAXIMIZE_CONVERSION_VALUE -> update.setMaximizeConversionValue(MaximizeConversionValue.newBuilder()
                    .setTargetRoas(bid).build());
            case TARGET_CPA -> update.setTargetCpa(TargetCpa.newBuilder()
                    .setTargetCpaMicros((long) (bid * m * MICROS)).build());
            case TARGET_ROAS -> update.setTargetRoas(TargetRoas.newBuilder()
                    .setTargetRoas(bid).build());
            default ->
                    throw new IllegalStateException("Unimplemented value of biddingStrategyType: %s in campaign %d/%d"
                            .formatted(update.getBiddingStrategyType(), customerId, campaignId));
        }

        createOrUpdate(principal, customerId, update.build());
        return findByIdFast(principal, customerId, campaignId);
    }

    public GoogleAdsRow setBudget(Principal principal, long customerId, long campaignId, long budgetMicros) throws Exception {
        CampaignBudget budget = findById(principal, customerId, campaignId)
                .getCampaign()
                .getCampaignBudget();

        provider().budgets().save(principal, customerId, CampaignBudget.newBuilder()
                .setId(budget.getId())
                .setResourceName(budget.getResourceName())
                .setAmountMicros(budgetMicros)
                .build());

        return findByIdFast(principal, customerId, campaignId);
    }

    public CampaignName save(Principal principal, long customerId, Campaign campaign) throws Exception {
        return createOrUpdate(principal, customerId, campaign);
    }

    public Iterator<GoogleAdsRow> report(Principal principal, long customerId, CampaignReportRequestDto request) throws Exception {
        QueryBuilder query = new QueryBuilder()
                .select(Gaql.Campaign.id,
                        Gaql.Campaign.name,
                        Gaql.Customer.id,
                        Gaql.Customer.currencyCode,
                        "metrics.clicks",
                        "metrics.impressions",
                        "metrics.cost_micros",
                        "metrics.conversions",
                        "metrics.view_through_conversions",
                        "metrics.conversions_value",
                        "segments.date",
                        Gaql.UserLocationView.countryCriterionId,
                        Gaql.Campaign.appCampaignSettingAppId)
                .from(Gaql.Table.userLocationView)
                .where("segments.date BETWEEN :startDate AND :endDate")
                .withBindVariableValue("startDate", request.getStartDate().format(YYYYMMDD))
                .withBindVariableValue("endDate", request.getEndDate().format(YYYYMMDD));

        var campaignIds = request.getCampaignIds();

        if (campaignIds != null && !campaignIds.isEmpty()) {
            query.where(" AND " + Gaql.Campaign.id + " IN (:campaignIds)")
                    .withBindVariableValue("campaignIds", campaignIds.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(",")));
        }

        query.orderBy("segments.date");

        return query(principal, customerId, query);
    }

    private CampaignName createOrUpdate(Principal principal, long customerId, Campaign campaign) throws Exception {
        try (CampaignServiceClient client = provider()
                .createClient(principal)
                .getLatestVersion()
                .createCampaignServiceClient()) {
            CampaignOperation operation;

            if (StringUtils.isEmpty(campaign.getResourceName())) {
                operation = CampaignOperation.newBuilder()
                        .setCreate(campaign)
                        .build();
            } else {
                Campaign.Builder campaignBuilder = campaign.toBuilder()
                        .clearAdvertisingChannelType()
                        .clearAdvertisingChannelSubType();

                if (campaign.hasAppCampaignSetting())
                    campaignBuilder.setAppCampaignSetting(campaign.getAppCampaignSetting()
                            .toBuilder()
                            .clearAppId()
                            .clearAppStore());

                campaign = campaignBuilder.build();

                operation = CampaignOperation.newBuilder()
                        .setUpdate(campaign)
                        .setUpdateMask(FieldMasks.allSetFieldsOf(campaign))
                        .build();
            }

            String resourceName = client.mutateCampaigns(Long.toString(customerId), List.of(operation))
                    .getResults(0)
                    .getResourceName();

            return CampaignName.parse(resourceName);
        }
    }

    private QueryBuilder buildFindAllQuery(long customerId, FindAllCampaignsRequestDto request) {
        QueryBuilder query = campaignQuery.clone()
                .where(Gaql.Customer.id + " = :customerId")
                .withBindVariableValue("customerId", customerId)
                .orderBy(Gaql.Campaign.name);

        if (!StringUtils.isEmpty(request.getName())) {
            query.where(" AND " + Gaql.Campaign.name + " LIKE '%:name%'")
                    .withBindVariableValue("name", request.getName());
        }

        if (!request.getStatus().isEmpty()) {
            query.where(" AND " + Gaql.Campaign.status + " IN (:status)")
                    .withBindVariableValue("status", request.getStatus()
                            .stream()
                            .map("'%s'"::formatted)
                            .collect(Collectors.joining(",")));
        }

        if (!request.getCampaignIds().isEmpty()) {
            query.where(" AND " + Gaql.Campaign.id + " IN (:campaignIds)")
                    .withBindVariableValue("campaignIds", request.getCampaignIds()
                            .stream()
                            .map("%s"::formatted)
                            .collect(Collectors.joining(",")));
        }

        if (!StringUtils.isEmpty(request.getBundleId())) {
            query.where(" AND " + Gaql.Campaign.appCampaignSettingAppId + " = ':bundleId'")
                    .withBindVariableValue("bundleId", request.getBundleId());
        }

        return query;
    }
}
