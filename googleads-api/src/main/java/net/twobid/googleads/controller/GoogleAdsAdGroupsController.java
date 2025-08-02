/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.controller;

import com.google.ads.googleads.v16.enums.AdGroupStatusEnum;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import net.twobid.googleads.dto.AdGroupDto;
import net.twobid.googleads.dto.AdGroupNameDto;
import net.twobid.googleads.dto.AdGroupStatus;
import net.twobid.googleads.mapper.AdGroupMapper;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import net.twobid.shared.model.PageTokenPage;
import net.twobid.shared.model.PageTokenPageable;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping("/googleads-api/v1/campaigns/{customerId}/{campaignId}/adgroups")
@Tag(name = "GoogleAdsAdGroups", description = "Google Ads AdGroups API")
public class GoogleAdsAdGroupsController {
    private final AdGroupMapper adGroupMapper;
    private final GoogleAdsDataProvider googleAdsDataProvider;

    @GetMapping
    public PageTokenPage<AdGroupDto> findAll(@NotNull Principal principal,
                                             @PathVariable @NotNull long customerId,
                                             @PathVariable @NotNull long campaignId,
                                             @ParameterObject PageTokenPageable pageable) throws Exception {
        return googleAdsDataProvider.adGroups().findAll(principal, customerId, campaignId, pageable, adGroupMapper::resolve);
    }

    @GetMapping({"{adGroupId}"})
    public AdGroupDto findById(@NotNull Principal principal,
                               @PathVariable @NotNull long customerId,
                               @PathVariable @NotNull long campaignId,
                               @PathVariable @NotNull long adGroupId) throws Exception {
        return adGroupMapper.resolve(
                googleAdsDataProvider.adGroups().findById(principal, customerId, campaignId, adGroupId)
        );
    }

    @GetMapping({"{adGroupId}/name"})
    public AdGroupNameDto nameById(@NotNull Principal principal,
                                   @PathVariable @NotNull long customerId,
                                   @PathVariable @NotNull long campaignId,
                                   @PathVariable @NotNull long adGroupId) throws Exception {
        return adGroupMapper.resolveName(
                googleAdsDataProvider.adGroups().nameById(principal, customerId, campaignId, adGroupId)
        );
    }

    @PostMapping({"{adGroupId}/status"})
    public AdGroupDto status(@NotNull Principal principal,
                             @PathVariable @NotNull long customerId,
                             @PathVariable @NotNull long campaignId,
                             @PathVariable @NotNull long adGroupId,
                             @RequestBody AdGroupStatus status) throws Exception {
        return adGroupMapper.resolve(
                googleAdsDataProvider.adGroups().setStatus(principal,
                        customerId,
                        campaignId,
                        adGroupId,
                        AdGroupStatusEnum.AdGroupStatus.valueOf(status.toString())
                )
        );
    }

    @PostMapping
    public AdGroupDto save(@NotNull Principal principal,
                           @PathVariable @NotNull long customerId,
                           @PathVariable @NotNull long campaignId,
                           @RequestBody @NotNull AdGroupDto request) throws Exception {
        return adGroupMapper.resolve(
                googleAdsDataProvider.adGroups().save(principal, customerId, campaignId,
                        adGroupMapper.resolve(request)
                )
        );
    }
}

