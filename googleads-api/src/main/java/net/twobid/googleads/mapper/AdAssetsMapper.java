/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.mapper;

import com.google.ads.googleads.v16.common.AdTextAsset;
import com.google.ads.googleads.v16.common.AdVideoAsset;
import com.google.ads.googleads.v16.common.AppAdInfo;
import com.google.ads.googleads.v16.resources.Ad;
import com.google.ads.googleads.v16.resources.AdGroupAd;
import com.google.ads.googleads.v16.resources.Asset;
import com.google.ads.googleads.v16.services.GoogleAdsRow;
import net.twobid.googleads.dto.*;
import net.twobid.googleads.provider.model.AdAssetsByApp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@Mapper(componentModel = "spring")
public abstract class AdAssetsMapper {
    @Autowired
    private CampaignMapper campaignMapper;

    @Mapping(target = "text", source = "asset")
    public abstract AdTextAsset resolveTextAsset(String asset);

    @Mapping(target = "asset", source = "asset")
    public abstract AdVideoAsset resolveVideoAsset(String asset);

    public AdGroupAd resolve(AdAssetSaveRequest request) {
        Ad.Builder ad = Ad.newBuilder();
        AppAdInfo.Builder adInfo = AppAdInfo.newBuilder();

        if(request.getAdId() != null)
            ad.setId(request.getAdId());

        for(AdAssetDto asset : request.getAssets()) {
            if(asset.getFieldType() == AssetFieldType.HEADLINE) {
                adInfo.addHeadlines(resolveTextAsset(asset.getText()));
            } else if(asset.getFieldType() == AssetFieldType.DESCRIPTION) {
                adInfo.addDescriptions(resolveTextAsset(asset.getText()));
            } else if(asset.getFieldType() == AssetFieldType.YOUTUBE_VIDEO) {
                adInfo.addYoutubeVideos(resolveVideoAsset(asset.getYoutubeVideoId()));
            } else {
                throw new IllegalArgumentException("Unsupported asset field type: " + asset.getFieldType());
            }
        }

        ad.setAppAd(adInfo.build());

        return AdGroupAd.newBuilder()
                .setAd(ad)
                .build();
    }

    public AdAssetDto resolve(GoogleAdsRow row) {
        String text = row.getAsset().hasTextAsset() ? row.getAsset().getTextAsset().getText() : null;
        String youtubeVideoId = row.getAsset().hasYoutubeVideoAsset() ? row.getAsset().getYoutubeVideoAsset().getYoutubeVideoId() : null;

        return new AdAssetDto()
                .setId(row.getAsset().getId())
                .setFieldType(AssetFieldType.fromString(row.getAdGroupAdAssetView().getFieldType().name()))
                .setPerformanceLabel(AssetPerformanceLabel.fromString(row.getAdGroupAdAssetView().getPerformanceLabel().name()))
                .setText(text)
                .setYoutubeVideoId(youtubeVideoId);
    }

    public AdAssetListDto resolve(List<GoogleAdsRow> items) {
        Long adId = null;
        Long adGroupId = null;

        if(!items.isEmpty()) {
            GoogleAdsRow firstItem = items.get(0);
            adId = firstItem.getAdGroupAd().getAd().getId();
            adGroupId = firstItem.getAdGroup().getId();
        }

        return new AdAssetListDto()
                .setAdId(adId)
                .setAdGroupId(adGroupId)
                .setAssets(items.stream().map(this::resolve).toList());
    }

    public AdAssetsByAppDto resolve(AdAssetsByApp result) {
        Map<Long, List<AdAssetDto>> assetsByCampaignId = new LinkedHashMap<>();

        for (GoogleAdsRow row : result.getAssets()) {
            long campaignId = row.getCampaign().getId();
            assetsByCampaignId.computeIfAbsent(campaignId, k -> new ArrayList<>())
                    .add(resolve(row));
        }

        return new AdAssetsByAppDto()
                .setPackageName(result.getPackageName())
                .setCampaigns(result.getCampaigns().stream().map(campaignMapper::resolve).toList())
                .setAssetsByCampaignId(assetsByCampaignId);
    }

    public String resolveYoutubeUrl(Asset videoAsset) {
        return videoAsset.getYoutubeVideoAsset().getYoutubeVideoId();
    }

    public abstract List<String> resolveYoutubeUrls(List<Asset> videoAssets);
}
