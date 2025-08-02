/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.provider.impl;

import com.google.ads.googleads.lib.utils.FieldMasks;
import com.google.ads.googleads.v16.common.AdVideoAsset;
import com.google.ads.googleads.v16.common.YoutubeVideoAsset;
import com.google.ads.googleads.v16.enums.ResponseContentTypeEnum;
import com.google.ads.googleads.v16.errors.DatabaseErrorEnum;
import com.google.ads.googleads.v16.errors.GoogleAdsException;
import com.google.ads.googleads.v16.errors.GoogleAdsFailure;
import com.google.ads.googleads.v16.resources.Ad;
import com.google.ads.googleads.v16.resources.AdGroupAd;
import com.google.ads.googleads.v16.resources.Asset;
import com.google.ads.googleads.v16.services.*;
import com.google.ads.googleads.v16.utils.ResourceNames;
import net.twobid.googleads.dto.AdGroupAppAdsByAppRequest;
import net.twobid.googleads.dto.AssetPerformanceLabel;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import net.twobid.googleads.provider.model.AdAssetsByApp;
import net.twobid.googleads.query.Gaql;
import net.twobid.googleads.query.QueryBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class GoogleAdsAdAssetsProvider extends GoogleAdsDataProvider.ProviderAware<GoogleAdsAdAssetsProvider> {
    private static final Logger log = LoggerFactory.getLogger(GoogleAdsAdAssetsProvider.class);
    private final QueryBuilder adGroupAdQuery = new QueryBuilder()
            .select(Gaql.AdGroup.id,
                    Gaql.AdGroupAd.adId,
                    Gaql.AdGroupAd.adType,
                    Gaql.Asset.id,
                    Gaql.Asset.textAssetText,
                    Gaql.Asset.youtubeVideoAssetYoutubeVideoId,
                    Gaql.AdGroupAdAssetView.fieldType,
                    Gaql.AdGroupAdAssetView.performanceLabel,
                    Gaql.AdGroupAdAssetView.enabled,
                    Gaql.Campaign.id)
            .from(Gaql.Table.adGroupAdAssetView);

    public AdAssetsByApp findAll(Principal principal, long customerId, AdGroupAppAdsByAppRequest request) throws Exception {
        List<GoogleAdsRow> campaigns = new ArrayList<>();

        provider().campaigns()
                .findAll(principal, customerId, request.getCampaignsFilter())
                .forEachRemaining(campaigns::add);

        if (campaigns.isEmpty())
            throw new NoSuchElementException("No campaigns found for the given filter");

        QueryBuilder query = adGroupAdQuery.clone()
                .select(Gaql.Campaign.id,
                        Gaql.Campaign.name,
                        Gaql.Campaign.appCampaignSettingAppId)
                .where(Gaql.AdGroup.status + " = 'ENABLED'")
                .where(" AND " + Gaql.AdGroupAd.status + " = 'ENABLED'")
                .where(" AND " + Gaql.Campaign.id + " IN (:campaignIds)")
                .where(" AND " + Gaql.AdGroupAdAssetView.enabled + " = true")
                .withBindVariableValue("campaignIds", StringUtils.join(
                        campaigns.stream().map(r -> r.getCampaign().getId()).toList(), ","));

        Set<GoogleAdsRow> allAds = new LinkedHashSet<>();

        Iterator<GoogleAdsRow> it = query(principal, customerId, query);
        it.forEachRemaining(row -> {
            AssetPerformanceLabel performanceLabel = AssetPerformanceLabel.fromString(
                    row.getAdGroupAdAssetView().getPerformanceLabel().name()
            );

            if (request.getPerformanceLabels().isEmpty() || request.getPerformanceLabels().contains(performanceLabel)) {
                allAds.add(row);
            }
        });

        long campaignId = 0L;
        long adGroupId = 0L;

        List<GoogleAdsRow> resultAds = new ArrayList<>(allAds);

        for (GoogleAdsRow row : resultAds) {
            if (campaignId == 0L)
                campaignId = row.getCampaign().getId();
            if (adGroupId == 0L)
                adGroupId = row.getAdGroup().getId();
            if (campaignId != 0L && adGroupId != 0L)
                break;
        }

        return new AdAssetsByApp()
                .setPackageName(request.getCampaignsFilter().getBundleId())
                .setCustomerId(customerId)
                .setCampaignId(campaignId)
                .setAdGroupId(adGroupId)
                .setCampaigns(campaigns)
                .setAssets(resultAds);
    }

    public List<GoogleAdsRow> findAllByAdGroupId(Principal principal, long customerId, long adGroupId) throws Exception {
        QueryBuilder query = adGroupAdQuery.clone()
                .where(Gaql.AdGroup.id + " = :adGroupId")
                .where(" AND " + Gaql.AdGroupAdAssetView.enabled + " = true")
                .withBindVariableValue("adGroupId", adGroupId);

        return queryList(principal, customerId, query);
    }

    public List<GoogleAdsRow> save(Principal principal, long customerId, long adGroupId, AdGroupAd adGroupAd) throws Exception {
        List<AdVideoAsset> youtubeVideoList = adGroupAd.getAd().getAppAd().getYoutubeVideosList();

        if (youtubeVideoList.isEmpty()) {
            //TODO: unable to remove all videos, always one must left to get other videos deleted?
            adGroupAd = AdGroupAd.newBuilder()
                    .mergeFrom(adGroupAd)
                    .setAd(Ad.newBuilder()
                            .mergeFrom(adGroupAd.getAd())
                            .setAppAd(adGroupAd.getAd()
                                    .getAppAd()
                                    .toBuilder()
                                    .addYoutubeVideos(AdVideoAsset.newBuilder().build())
                                    .clearYoutubeVideos()
                                    .build())
                            .build())
                    .build();
        } else {
            List<String> resourceNames = resolveVideoAssetResourceNames(principal,
                    customerId, youtubeVideoList.stream().map(AdVideoAsset::getAsset).toList());

            adGroupAd = AdGroupAd.newBuilder()
                    .mergeFrom(adGroupAd)
                    .setAd(Ad.newBuilder()
                            .mergeFrom(adGroupAd.getAd())
                            .setAppAd(adGroupAd.getAd()
                                    .getAppAd()
                                    .toBuilder()
                                    .clearYoutubeVideos()
                                    .addAllYoutubeVideos(resourceNames.stream()
                                            .map(rn -> AdVideoAsset.newBuilder()
                                                    .setAsset(rn)
                                                    .build())
                                            .toList())
                                    .build())
                            .build())
                    .build();
        }

        if (adGroupAd.getAd().hasId()) {
            try (AdServiceClient adServiceClient = provider()
                    .createClient(principal)
                    .getLatestVersion()
                    .createAdServiceClient()) {
                Ad ad = Ad.newBuilder()
                        .mergeFrom(adGroupAd.getAd())
                        .setResourceName(ResourceNames.ad(customerId, adGroupAd.getAd().getId()))
                        .clearId()
                        .build();

                adServiceClient.mutateAds(MutateAdsRequest.newBuilder()
                        .setCustomerId(String.valueOf(customerId))
                        .addOperations(AdOperation.newBuilder()
                                .setUpdate(ad)
                                .setUpdateMask(FieldMasks.allSetFieldsOf(ad))
                                .build())
                        .build());
            }
        } else {
            try (AdGroupAdServiceClient adGroupAdServiceClient = provider()
                    .createClient(principal)
                    .getLatestVersion()
                    .createAdGroupAdServiceClient()) {

                mutateAdGroupAdsWithRetry(adGroupAdServiceClient, customerId, 3, AdGroupAdOperation.newBuilder()
                        .setCreate(AdGroupAd.newBuilder()
                                .mergeFrom(adGroupAd)
                                .setAdGroup(ResourceNames.adGroup(customerId, adGroupId))
                                .build())
                        .build());
            }
        }

        return findAllByAdGroupId(principal, customerId, adGroupId);
    }

    public List<Asset> findAllVideoAssetsByAppId(Principal principal, long customerId, String appId) throws Exception {
        QueryBuilder query = new QueryBuilder()
                .select(Gaql.Asset.youtubeVideoAssetYoutubeVideoId)
                .from(Gaql.Table.adGroupAdAssetView)
                .where(Gaql.Asset.type + " = 'YOUTUBE_VIDEO'")
                .where(" AND " + Gaql.Campaign.appCampaignSettingAppId + " = ':appId'")
                .withBindVariableValue("appId", appId);

        return queryList(principal, customerId, query).stream()
                .map(GoogleAdsRow::getAsset)
                .distinct()
                .collect(Collectors.toList());
    }

    private List<String> resolveVideoAssetResourceNames(Principal principal,
                                                        long customerId,
                                                        List<String> youtubeVideoIds) throws Exception {
        QueryBuilder query = new QueryBuilder()
                .select(Gaql.Asset.resourceName, Gaql.Asset.youtubeVideoAssetYoutubeVideoId)
                .from(Gaql.Table.asset)
                .where(Gaql.Asset.youtubeVideoAssetYoutubeVideoId + " IN (:youtubeVideoIds)")
                .withBindVariableValue("youtubeVideoIds", StringUtils.join(youtubeVideoIds.stream().map(x -> "'" + x + "'").toList(), ","));

        Map<String, String> youtubeVideoIdToResourceName = new LinkedHashMap<>();
        for (String id : youtubeVideoIds) {
            youtubeVideoIdToResourceName.put(id, null);
        }

        queryList(principal, customerId, query).forEach(row -> {
            youtubeVideoIdToResourceName.put(row.getAsset().getYoutubeVideoAsset().getYoutubeVideoId(), row.getAsset().getResourceName());
        });

        List<AssetOperation> operations = new ArrayList<>();
        for (Map.Entry<String, String> kvp : youtubeVideoIdToResourceName.entrySet()) {
            String youtubeVideoId = kvp.getKey();
            String resourceName = kvp.getValue();

            if (resourceName == null) {
                com.google.ads.googleads.v16.resources.Asset asset = com.google.ads.googleads.v16.resources.Asset.newBuilder()
                        .setName("Youtube video " + youtubeVideoId)
                        .setType(com.google.ads.googleads.v16.enums.AssetTypeEnum.AssetType.YOUTUBE_VIDEO)
                        .setYoutubeVideoAsset(YoutubeVideoAsset.newBuilder()
                                .setYoutubeVideoId(youtubeVideoId)
                                .build())
                        .build();

                operations.add(AssetOperation.newBuilder()
                        .setCreate(asset)
                        .build());
            }
        }

        List<String> resourceNames = new ArrayList<>(
                youtubeVideoIdToResourceName.values().stream().filter(Objects::nonNull).toList());

        if (!operations.isEmpty()) {
            try (AssetServiceClient assetServiceClient = provider()
                    .createClient(principal)
                    .getLatestVersion()
                    .createAssetServiceClient()) {
                MutateAssetsResponse response = assetServiceClient.mutateAssets(Long.toString(customerId), operations);

                for (int i = 0; i < response.getResultsCount(); i++)
                    resourceNames.add(response.getResults(i).getResourceName());
            }
        }

        return resourceNames;
    }

    private void mutateAdGroupAdsWithRetry(AdGroupAdServiceClient adGroupAdServiceClient,
                                           long customerId,
                                           int retries,
                                           AdGroupAdOperation... operations) {
        try {
            adGroupAdServiceClient.mutateAdGroupAds(
                    MutateAdGroupAdsRequest.newBuilder()
                            .setCustomerId(Long.toString(customerId))
                            .addAllOperations(Arrays.asList(operations))
                            .setResponseContentType(ResponseContentTypeEnum.ResponseContentType.MUTABLE_RESOURCE)
                            .build());
        } catch (GoogleAdsException e) {
            GoogleAdsFailure failure = e.getGoogleAdsFailure();

            if (failure != null && failure.getErrorsCount() > 0) {
                DatabaseErrorEnum.DatabaseError error = failure.getErrors(0)
                        .getErrorCode()
                        .getDatabaseError();

                if (error == DatabaseErrorEnum.DatabaseError.CONCURRENT_MODIFICATION && retries > 0) {
                    log.info("Retrying mutateAdGroupAds operation because of CONCURRENT_MODIFICATION, retries left: {}", retries);
                    mutateAdGroupAdsWithRetry(adGroupAdServiceClient, customerId, retries - 1, operations);
                    return;
                }
            }

            throw e;
        }
    }
}
