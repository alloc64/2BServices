/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.provider.impl;

import com.google.ads.googleads.lib.utils.FieldMasks;
import com.google.ads.googleads.v16.enums.AdGroupStatusEnum;
import com.google.ads.googleads.v16.resources.AdGroup;
import com.google.ads.googleads.v16.resources.AdGroupName;
import com.google.ads.googleads.v16.services.AdGroupOperation;
import com.google.ads.googleads.v16.services.AdGroupServiceClient;
import com.google.ads.googleads.v16.services.GoogleAdsRow;
import com.google.ads.googleads.v16.services.MutateAdGroupsResponse;
import com.google.ads.googleads.v16.utils.ResourceNames;
import lombok.RequiredArgsConstructor;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import net.twobid.googleads.query.Gaql;
import net.twobid.googleads.query.QueryBuilder;
import net.twobid.shared.model.PageTokenPage;
import net.twobid.shared.model.PageTokenPageable;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class GoogleAdsAdGroupProvider extends GoogleAdsDataProvider.ProviderAware<GoogleAdsAdGroupProvider> {
    public <Output> PageTokenPage<Output> findAll(Principal principal,
                                                  long customerId,
                                                  long campaignId,
                                                  PageTokenPageable pageable,
                                                  PageTokenPage.ValueMapper<GoogleAdsRow, Output> mapper) throws Exception {
        QueryBuilder query = new QueryBuilder()
                .select(Gaql.AdGroup.id,
                        Gaql.AdGroup.name,
                        Gaql.AdGroup.status,
                        Gaql.Customer.id,
                        Gaql.Campaign.id)
                .from(Gaql.Table.adGroup)
                .orderBy(Gaql.AdGroup.name)
                .where(Gaql.Campaign.id + " = :campaignId")
                .withBindVariableValue("campaignId", campaignId);

        return queryPaged(principal, customerId, query, pageable, mapper);
    }

    public GoogleAdsRow findById(Principal principal,
                                 long customerId,
                                 long campaignId,
                                 long adGroupId) throws Exception {
        QueryBuilder query = new QueryBuilder()
                .select(Gaql.AdGroup.id,
                        Gaql.AdGroup.name,
                        Gaql.AdGroup.status,
                        Gaql.Customer.id,
                        Gaql.Campaign.id)
                .from(Gaql.Table.adGroup)
                .where(Gaql.AdGroup.id + " = :adGroupId")
                .withBindVariableValue("adGroupId", adGroupId);

        return querySingle(principal, customerId, query)
                .orElseThrow(() -> new NoSuchElementException("AdGroup customer/%s/campaign/%s/adgroup/%s was not found."
                        .formatted(customerId, campaignId, adGroupId)));
    }

    public GoogleAdsRow nameById(Principal principal, long customerId, long campaignId, long adGroupId) throws Exception {
        QueryBuilder query = new QueryBuilder()
                .select(Gaql.AdGroup.name)
                .from(Gaql.Table.adGroup)
                .where(Gaql.AdGroup.id + " = :adGroupId")
                .withBindVariableValue("adGroupId", adGroupId);

        return querySingle(principal, customerId, query)
                .orElseThrow(() -> new NoSuchElementException("AdGroup customer/%s/campaign/%s/adgroup/%s was not found."
                        .formatted(customerId, campaignId, adGroupId)));

    }

    public GoogleAdsRow save(Principal principal, long customerId, long campaignId, AdGroup request) throws Exception {
        try (AdGroupServiceClient adGroupClient = provider().createClient(principal)
                .getLatestVersion()
                .createAdGroupServiceClient()) {

            AdGroupOperation operation;
            if (request.hasId()) {
                AdGroup adGroup = AdGroup.newBuilder()
                        .mergeFrom(findById(principal, customerId, campaignId, request.getId()).getAdGroup())
                        .setName(request.getName())
                        .setStatus(request.getStatus())
                        .build();

                operation = AdGroupOperation.newBuilder()
                        .setUpdate(adGroup)
                        .setUpdateMask(FieldMasks.allSetFieldsOf(adGroup))
                        .build();
            } else {
                operation = AdGroupOperation.newBuilder()
                        .setCreate(AdGroup.newBuilder()
                                .setName(request.getName())
                                .setStatus(request.getStatus())
                                .setCampaign(ResourceNames.campaign(customerId, campaignId)))
                        .build();

            }
            String resourceName = adGroupClient.mutateAdGroups(
                            Long.toString(customerId),
                            List.of(operation)
                    )
                    .getResults(0)
                    .getResourceName();

            long adGroupId = Long.parseLong(AdGroupName.parse(resourceName).getAdGroupId());
            return findById(principal, customerId, campaignId, adGroupId);
        }
    }

    public GoogleAdsRow setStatus(Principal principal,
                                  long customerId,
                                  long campaignId,
                                  long adGroupId,
                                  AdGroupStatusEnum.AdGroupStatus status) throws Exception {
        try (AdGroupServiceClient client = provider().createClient(principal)
                .getLatestVersion()
                .createAdGroupServiceClient()) {
            update(client, customerId, AdGroup.newBuilder()
                    .setResourceName(ResourceNames.adGroup(customerId, adGroupId))
                    .setStatus(status)
                    .build());
        }

        return findById(principal, customerId, campaignId, adGroupId);
    }

    private MutateAdGroupsResponse update(AdGroupServiceClient client, long customerId, AdGroup adGroup) {
        return client.mutateAdGroups(Long.toString(customerId), List.of(AdGroupOperation.newBuilder()
                .setUpdate(adGroup)
                .setUpdateMask(FieldMasks.allSetFieldsOf(adGroup))
                .build()));
    }
}


