/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.provider.impl;

import com.google.ads.googleads.v16.common.LocationInfo;
import com.google.ads.googleads.v16.resources.CampaignCriterion;
import com.google.ads.googleads.v16.resources.GeoTargetConstant;
import com.google.ads.googleads.v16.services.*;
import com.google.ads.googleads.v16.utils.ResourceNames;
import lombok.RequiredArgsConstructor;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import net.twobid.googleads.query.Gaql;
import net.twobid.googleads.query.QueryBuilder;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GoogleAdsTargetingProvider extends GoogleAdsDataProvider.ProviderAware<GoogleAdsTargetingProvider> {
    public List<GeoTargetConstant> findAll(Principal principal, SuggestGeoTargetConstantsRequest request) throws Exception {
        if(request.getGeoTargets().getGeoTargetConstantsCount() == 0 && request.getLocationNames().getNamesCount() == 0)
            return new ArrayList<>();

        try (GeoTargetConstantServiceClient geoTargetClient = provider()
                .createClient(principal)
                .getLatestVersion()
                .createGeoTargetConstantServiceClient()) {
            return geoTargetClient
                    .suggestGeoTargetConstants(request)
                    .getGeoTargetConstantSuggestionsList()
                    .stream()
                    .map(GeoTargetConstantSuggestion::getGeoTargetConstant)
                    .filter(geoTargetConstant -> "Country".equals(geoTargetConstant.getTargetType()))
                    .toList();
        }
    }

    public List<GeoTargetConstant> findByCampaignId(Principal principal, long customerId, long campaignId) throws Exception {
        QueryBuilder criterionBuilder = new QueryBuilder()
                .select(Gaql.CampaignCriterion.locationGeoTargetConstant)
                .from(Gaql.Table.campaignCriterion)
                .where(Gaql.Campaign.id + " = :campaignId")
                .where(" AND " + Gaql.CampaignCriterion.locationGeoTargetConstant + " IS NOT NULL")
                .withBindVariableValue("campaignId", campaignId);

        List<String> geoTargetConstants = queryList(principal, customerId, criterionBuilder).stream()
                .map(r -> r.getCampaignCriterion().getLocation().getGeoTargetConstant())
                .toList();

        return provider().targeting().findAll(principal,
                SuggestGeoTargetConstantsRequest.newBuilder()
                        .setGeoTargets(SuggestGeoTargetConstantsRequest.GeoTargets.newBuilder()
                                .addAllGeoTargetConstants(geoTargetConstants)
                                .build())
                        .build());
    }

    public void save(Principal principal, long customerId, long campaignId, List<LocationInfo> locationInfos) throws Exception {
        QueryBuilder query = new QueryBuilder()
                .select(Gaql.CampaignCriterion.locationGeoTargetConstant)
                .from(Gaql.Table.campaignCriterion)
                .where(Gaql.Campaign.id + " = :campaignId")
                .where(" AND " + Gaql.CampaignCriterion.locationGeoTargetConstant + " IS NOT NULL")
                .withBindVariableValue("campaignId", campaignId);

        List<GoogleAdsRow> existingCriteria = queryList(principal, customerId, query);

        try (CampaignCriterionServiceClient criterionClient = provider()
                .createClient(principal)
                .getLatestVersion()
                .createCampaignCriterionServiceClient()) {

            if(!existingCriteria.isEmpty()) {
                update(criterionClient, customerId,
                        existingCriteria.stream().map(row ->
                                CampaignCriterionOperation.newBuilder()
                                        .setRemove(row.getCampaignCriterion().getResourceName())
                                        .build())
                                .toList()
                );
            }

            if(!locationInfos.isEmpty()) {
                update(criterionClient, customerId, locationInfos.stream()
                        .map(locationInfo -> CampaignCriterionOperation.newBuilder()
                                .setCreate(CampaignCriterion.newBuilder()
                                        .setCampaign(ResourceNames.campaign(customerId, campaignId))
                                        .setLocation(locationInfo)
                                        .build())
                                .build())
                        .toList());
            }
        }
    }

    private void update(CampaignCriterionServiceClient criterionClient,
                                         long customerId,
                                         List<CampaignCriterionOperation> ops) {
        criterionClient.mutateCampaignCriteria(Long.toString(customerId), ops);
    }
}
