/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.mapper;

import com.google.ads.googleads.v15.resources.CampaignName;
import com.google.ads.googleads.v16.common.MaximizeConversionValue;
import com.google.ads.googleads.v16.common.MaximizeConversions;
import com.google.ads.googleads.v16.common.TargetCpa;
import com.google.ads.googleads.v16.common.TargetRoas;
import com.google.ads.googleads.v16.enums.*;
import com.google.ads.googleads.v16.resources.Campaign;
import com.google.ads.googleads.v16.services.GoogleAdsRow;
import net.twobid.billing.api.CoreApi;
import net.twobid.googleads.dto.*;
import net.twobid.googleads.provider.model.CampaignDetail;
import net.twobid.googleads.utils.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Mapper(componentModel = "spring")
public abstract class CampaignMapper {
    @Autowired
    private CoreApi coreApi;
    @Autowired
    private ConversionActionMapper conversionActionMapper;
    @Autowired
    private TargetingMapper targetingMapper;

    public CampaignDto resolve(CampaignDetail detail) {
        return resolve(detail.getCampaign())
                .setLocationTargeting(new LocationTargetingDto()
                        .setGeoTargetConstants(targetingMapper.resolve(detail.getLocationTargetingGeoTargetConstants())))
                .setConversionActions(conversionActionMapper.resolve(detail.getConversionActions()));
    }

    public abstract List<CampaignDto> resolveList(List<CampaignDetail> details);

    public CampaignDto resolve(GoogleAdsRow row) {
        Campaign campaign = row.getCampaign();

        String currencyCode =  row.getCustomer().getCurrencyCode();
        double m = NumberUtils.roundSinglePlace(coreApi.currencyRate()
                .findByDate(LocalDate.now(), currencyCode)
                .blockingSingle());

        return new CampaignDto()
                .setId(campaign.getId())
                .setCustomerId(row.getCustomer().getId())
                .setAccountCurrencyCode(currencyCode)
                .setName(campaign.getName())
                .setBudget((long) (row.getCampaignBudget().getAmountMicros() / m))
                .setStartDate(campaign.getStartDate())
                .setEndDate(campaign.getEndDate())
                .setStatus(CampaignStatus.fromString(campaign.getStatus().name()))
                .setBiddingStrategyType(BiddingStrategyType.fromString(campaign.getBiddingStrategyType().name()))
                .setConversionActions(row.hasConversionAction() ? List.of(conversionActionMapper.resolve(row.getConversionAction())) : new ArrayList<>())
                .setTargetCpa(campaign.hasTargetCpa() ? new CampaignDto.TargetCpa()
                        .setMicros((long) (campaign.getTargetCpa().getTargetCpaMicros() / m)) : null)
                .setMaximizeConversionsTargetCpa(campaign.hasMaximizeConversions() ? new CampaignDto.MaximizeConversionsTargetCpa()
                        .setMicros((long) (campaign.getMaximizeConversions().getTargetCpaMicros() / m)) : null)
                .setMaximizeConversionValue(campaign.hasMaximizeConversionValue() ? new CampaignDto.MaximizeConversionValue()
                        .setValue(campaign.getMaximizeConversionValue().getTargetRoas()) : null)
                .setTargetRoas(campaign.hasTargetRoas() ? new CampaignDto.TargetRoas()
                        .setRoas(campaign.getTargetRoas().getTargetRoas() ) : null)
                .setPackageName(campaign.hasAppCampaignSetting() ? campaign.getAppCampaignSetting().getAppId() : null)
                .setScore(campaign.getOptimizationScore());
    }

    public abstract List<CampaignDto> resolve(List<GoogleAdsRow> list);

    public Campaign.Builder resolve(CampaignDto request) {
        Campaign.Builder builder = Campaign.newBuilder()
                .setName(request.getName())
                .setStatus(request.getStatus() == null ? CampaignStatusEnum.CampaignStatus.PAUSED : CampaignStatusEnum.CampaignStatus.valueOf(request.getStatus().toString()))
                .setAdvertisingChannelType(AdvertisingChannelTypeEnum.AdvertisingChannelType.MULTI_CHANNEL)
                .setAdvertisingChannelSubType(AdvertisingChannelSubTypeEnum.AdvertisingChannelSubType.APP_CAMPAIGN);

        if(request.getId() != null)
            builder.setResourceName(
                    CampaignName.of(String.valueOf(request.getCustomerId()), String.valueOf(request.getId())).toString()
            );

        if(request.getId() != null)
            builder.setId(request.getId());

        if(!StringUtils.isEmpty(request.getStartDate()))
            builder.setStartDate(request.getStartDate());

        if(!StringUtils.isEmpty(request.getEndDate()))
            builder.setEndDate(request.getEndDate());

        double m = NumberUtils.roundSinglePlace(coreApi.currencyRate()
                .findByDate(LocalDate.now(), request.getAccountCurrencyCode())
                .blockingSingle());

        AppCampaignBiddingStrategyGoalTypeEnum.AppCampaignBiddingStrategyGoalType goalType;

        if (request.getTargetCpa() != null) {
            builder.setTargetCpa(TargetCpa.newBuilder()
                    .setTargetCpaMicros((long) (request.getTargetCpa().getMicros() * m))
                    .build());
            goalType = AppCampaignBiddingStrategyGoalTypeEnum.AppCampaignBiddingStrategyGoalType.OPTIMIZE_INSTALLS_TARGET_INSTALL_COST;
        } else if (request.getMaximizeConversionsTargetCpa() != null) {
            builder.setMaximizeConversions(MaximizeConversions.newBuilder()
                    .setTargetCpaMicros((long) (request.getMaximizeConversionsTargetCpa().getMicros() * m))
                    .build());
            goalType = AppCampaignBiddingStrategyGoalTypeEnum.AppCampaignBiddingStrategyGoalType.OPTIMIZE_IN_APP_CONVERSIONS_TARGET_INSTALL_COST;
        } else if (request.getMaximizeConversionValue() != null) {
            builder.setMaximizeConversionValue(MaximizeConversionValue.newBuilder()
                    .setTargetRoas(request.getMaximizeConversionValue().getValue())
                    .build());
            goalType = AppCampaignBiddingStrategyGoalTypeEnum.AppCampaignBiddingStrategyGoalType.OPTIMIZE_IN_APP_CONVERSIONS_TARGET_CONVERSION_COST;
        } else if (request.getTargetRoas() != null) {
            builder.setTargetRoas(TargetRoas.newBuilder()
                    .setTargetRoas(request.getTargetRoas().getRoas())
                    .build());
            goalType = AppCampaignBiddingStrategyGoalTypeEnum.AppCampaignBiddingStrategyGoalType.OPTIMIZE_RETURN_ON_ADVERTISING_SPEND;
        } else {
            throw new IllegalStateException("No bidding strategy provided");
        }

        builder.setAppCampaignSetting(Campaign.AppCampaignSetting.newBuilder()
                .setAppId(request.getPackageName())
                .setAppStore(AppCampaignAppStoreEnum.AppCampaignAppStore.GOOGLE_APP_STORE)
                .setBiddingStrategyGoalType(goalType)
                .build());

        return builder;
    }

    @Mapping(target = "name", source = "campaign.name")
    public abstract CampaignNameDto resolveName(GoogleAdsRow row);

    @Mapping(target = "appId", source ="campaign.appCampaignSetting.appId")
    public abstract AppIdDto resolveAppId(GoogleAdsRow row);
}
