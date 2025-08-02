/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.twobid.googleads.dto.ConversionActionDto;
import net.twobid.googleads.mapper.ConversionActionMapper;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/googleads-api/v1/campaigns/{customerId}/conversion-actions")
@Tag(name = "GoogleAdsConversionActions", description = "Google Ads Conversion Actions API")
public class GoogleAdsConversionActionsController {
    private ConversionActionMapper conversionActionMapper;
    private GoogleAdsDataProvider googleAdsDataProvider;

    @GetMapping("/app/{appId}")
    public List<ConversionActionDto> findAll(Principal principal,
                                             @PathVariable long customerId,
                                             @PathVariable String appId) throws Exception {
        return googleAdsDataProvider.conversionActions()
                .findAll(principal, customerId, appId, conversionActionMapper::resolve);
    }

    @GetMapping("{conversionActionId}")
    public ConversionActionDto findById(Principal principal,
                                        @PathVariable long customerId,
                                        @PathVariable long conversionActionId)
            throws Exception {
        return conversionActionMapper.resolve(
                googleAdsDataProvider.conversionActions().findById(principal, customerId, conversionActionId)
        );
    }

    @PostMapping("save")
    public ConversionActionDto save(Principal principal,
                                    @PathVariable long customerId,
                                    @RequestBody ConversionActionDto conversionActionDto) throws Exception {
        return conversionActionMapper.resolve(
                googleAdsDataProvider.conversionActions().save(
                        principal,
                        customerId,
                        conversionActionMapper.resolve(conversionActionDto)
                )
        );
    }

    @DeleteMapping("{conversionActionId}")
    public void deleteCustomConversionAction(Principal principal,
                       @PathVariable long customerId,
                       @PathVariable long conversionActionId) {
        googleAdsDataProvider.conversionActions().deleteCustomConversionAction(
                principal, customerId, conversionActionId
        );
    }
}
