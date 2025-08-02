/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.controller;

import com.google.ads.googleads.v16.enums.CampaignStatusEnum;
import com.google.ads.googleads.v16.resources.Campaign;
import com.google.ads.googleads.v16.resources.CampaignBudgetName;
import com.google.ads.googleads.v16.resources.ConversionAction;
import com.google.ads.googleads.v16.services.GoogleAdsRow;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.twobid.googleads.dto.*;
import net.twobid.googleads.mapper.CampaignMapper;
import net.twobid.googleads.mapper.CampaignReportMapper;
import net.twobid.googleads.mapper.ConversionActionMapper;
import net.twobid.googleads.mapper.TargetingMapper;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import net.twobid.shared.model.PageTokenPage;
import net.twobid.shared.model.PageTokenPageable;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/googleads-api/v1/campaigns/{customerId}")
@Tag(name = "GoogleAdsCampaigns", description = "Google Ads Campaigns API")
public class GoogleAdsCampaignsController {
    private final CampaignMapper campaignMapper;
    private final CampaignReportMapper campaignReportMapper;
    private final ConversionActionMapper conversionActionMapper;
    private final TargetingMapper targetingMapper;

    private final GoogleAdsDataProvider googleAdsDataProvider;

    @PostMapping
    public PageTokenPage<CampaignDto> findAll(Principal principal,
                                              @PathVariable long customerId,
                                              @RequestBody @Valid FindAllCampaignsRequestDto request,
                                              @ParameterObject PageTokenPageable pageable) throws Exception {
        return googleAdsDataProvider.campaigns()
                .findAll(principal, customerId, request, pageable)
                .map(campaignMapper::resolve);
    }

    @PostMapping("{appId}/by-location")
    public List<CampaignDto> findAllTargetingLocation(Principal principal,
                                                      @PathVariable long customerId,
                                                      @PathVariable String appId,
                                                      @RequestBody @Valid LocationTargetingDto targeting) throws Exception {
        return campaignMapper.resolveList(
                googleAdsDataProvider.campaigns().findAllTargetingLocation(principal, customerId, appId, targeting)
        );
    }

    @GetMapping("{campaignId}")
    public CampaignDto findById(Principal principal, @PathVariable long customerId, @PathVariable long campaignId)
            throws Exception {
        return campaignMapper.resolve(
                googleAdsDataProvider.campaigns().findById(principal, customerId, campaignId)
        );
    }

    @GetMapping("{campaignId}/name")
    public CampaignNameDto nameById(Principal principal, @PathVariable long customerId, @PathVariable long campaignId)
            throws Exception {
        return campaignMapper.resolveName(
                googleAdsDataProvider.campaigns().findByIdFast(principal, customerId, campaignId)
        );
    }

    @GetMapping("{campaignId}/appId")
    public AppIdDto appIdById(Principal principal, @PathVariable long customerId, @PathVariable long campaignId)
            throws Exception {
        return campaignMapper.resolveAppId(
                googleAdsDataProvider.campaigns().findByIdFast(principal, customerId, campaignId)
        );
    }

    @PostMapping("report")
    public List<CampaignReportDto> report(Principal principal,
                                          @PathVariable long customerId,
                                          @RequestBody @Valid CampaignReportRequestDto request) throws Exception {
        return campaignReportMapper.resolve(googleAdsDataProvider.campaigns().report(principal, customerId, request));
    }

    @GetMapping("{campaignId}/report")
    public CampaignReportDto reportById(Principal principal,
                                        @PathVariable long customerId,
                                        @PathVariable long campaignId,
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate startDate,
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate endDate)
            throws Exception {
        Iterator<GoogleAdsRow> it = googleAdsDataProvider.campaigns()
                .report(principal, customerId, new CampaignReportRequestDto()
                        .setCampaignIds(List.of(campaignId))
                        .setStartDate(startDate)
                        .setEndDate(endDate));

        return it.hasNext() ? campaignReportMapper.resolve(it.next()) : null;
    }

    @PostMapping("{campaignId}/status")
    public CampaignDto status(Principal principal,
                              @PathVariable long customerId,
                              @PathVariable long campaignId,
                              @RequestBody CampaignStatus status) throws Exception {
        return campaignMapper.resolve(
                googleAdsDataProvider.campaigns().setStatus(
                        principal, customerId, campaignId, CampaignStatusEnum.CampaignStatus.valueOf(status.toString()))
        );
    }

    @PostMapping("{campaignId}/bid")
    @Operation(summary = "Set bid for campaign, bid value. Monetary value, value or percents percents are handled internally. " +
            "Currency is specified by the account.")
    public CampaignDto bid(Principal principal,
                           @PathVariable long customerId,
                           @PathVariable long campaignId,
                           @RequestBody double bid) throws Exception {
        return campaignMapper.resolve(
                googleAdsDataProvider.campaigns().setBid(principal, customerId, campaignId, bid)
        );
    }

    @PostMapping("{campaignId}/budget")
    @Operation(summary = "Set budget for campaign, budget value is in micros eg. (1$ * 1_000_000L) = your budget value. " +
            "Currency is specified by the account.")
    public CampaignDto budget(Principal principal,
                              @PathVariable long customerId,
                              @PathVariable long campaignId,
                              @RequestBody long budgetMicros) throws Exception {
        return campaignMapper.resolve(
                googleAdsDataProvider.campaigns().setBudget(principal, customerId, campaignId, budgetMicros)
        );
    }

    @PostMapping("{campaignId}/targeting")
    public void targeting(Principal principal,
                          @PathVariable long customerId,
                          @PathVariable long campaignId,
                          @RequestBody @Valid LocationTargetingDto targeting) throws Exception {
        googleAdsDataProvider.targeting().save(
                principal, customerId, campaignId, targetingMapper.resolve(targeting)
        );
    }

    @PostMapping("save")
    public CampaignDto save(Principal principal,
                            @PathVariable long customerId,
                            @RequestBody CampaignDto request) throws Exception {
        CampaignBudgetName budget = googleAdsDataProvider.budgets().save(
                principal,
                customerId, "Budget of campaign: " + request.getName(),
                request.getBudget()
        );

        request.setAccountCurrencyCode(googleAdsDataProvider.account().currencyCode(principal, customerId));

        Campaign.Builder campaign = campaignMapper.resolve(request);
        campaign.setCampaignBudget(budget.toString());

        List<String> conversionActions = googleAdsDataProvider.conversionActions()
                .findById(principal, customerId, conversionActionMapper.resolveConversionActionList(request.getConversionActions())
                        .stream()
                        .map(c -> Long.parseLong(c.getConversionActionId()))
                        .toList()
                ).stream()
                .map(ConversionAction::getResourceName)
                .toList();

        campaign.setSelectiveOptimization(Campaign.SelectiveOptimization.newBuilder()
                .addAllConversionActions(conversionActions)
                .build());

        long createdCampaignId = Long.parseLong(
                googleAdsDataProvider.campaigns().save(principal, customerId, campaign.build()).getCampaignId());

        googleAdsDataProvider.targeting().save(
                principal, customerId, createdCampaignId, targetingMapper.resolve(request.getLocationTargeting())
        );

        return findById(principal, customerId, createdCampaignId);
    }
}



