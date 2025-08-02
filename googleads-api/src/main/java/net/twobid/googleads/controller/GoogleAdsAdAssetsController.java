/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.twobid.googleads.dto.AdAssetListDto;
import net.twobid.googleads.dto.AdAssetSaveRequest;
import net.twobid.googleads.dto.AdAssetsByAppDto;
import net.twobid.googleads.dto.AdGroupAppAdsByAppRequest;
import net.twobid.googleads.mapper.AdAssetsMapper;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/googleads-api/v1/campaigns/{customerId}/assets")
@Tag(name = "GoogleAdsAdAssets", description = "Google Ads Ad Assets API")
public class GoogleAdsAdAssetsController {
    private final GoogleAdsDataProvider googleAdsDataProvider;
    private final AdAssetsMapper adAssetsMapper;

    @PostMapping
    public AdAssetsByAppDto findAll(Principal principal,
                                    @PathVariable long customerId,
                                    @RequestBody @Valid AdGroupAppAdsByAppRequest request) throws Exception {
        return adAssetsMapper.resolve(
                googleAdsDataProvider.adAssets().findAll(principal, customerId, request)
        );
    }

    @GetMapping("video/{appId}")
    public List<String> findAllVideoAssetsByAppId(Principal principal,
                                                  @PathVariable long customerId,
                                                  @PathVariable String appId) throws Exception {
        return adAssetsMapper.resolveYoutubeUrls(
                googleAdsDataProvider.adAssets().findAllVideoAssetsByAppId(principal, customerId, appId)
        );
    }

    @GetMapping("{adGroupId}")
    public AdAssetListDto findAllByAdGroupId(Principal principal,
                                             @PathVariable long customerId,
                                             @PathVariable long adGroupId) throws Exception {
        return adAssetsMapper.resolve(
                googleAdsDataProvider.adAssets().findAllByAdGroupId(principal, customerId, adGroupId)
        );
    }


    @PostMapping("{adGroupId}/save")
    public AdAssetListDto save(Principal principal,
                               @PathVariable long customerId,
                               @PathVariable long adGroupId,
                               @RequestBody @Valid AdAssetSaveRequest request) throws Exception {
        return adAssetsMapper.resolve(
                googleAdsDataProvider.adAssets().save(
                        principal,
                        customerId,
                        adGroupId,
                        adAssetsMapper.resolve(request)
                )
        );
    }

}

