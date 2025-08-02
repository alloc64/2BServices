/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.twobid.googleads.dto.GeoTargetConstantDto;
import net.twobid.googleads.dto.SuggestGeoTargetConstantsRequestDto;
import net.twobid.googleads.mapper.TargetingMapper;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/googleads-api/v1/campaigns/{customerId}/targeting")
@Tag(name = "GoogleAdsTargeting", description = "Google Ads Targeting API")
public class GoogleAdsTargetingController {
    private final GoogleAdsDataProvider googleAdsDataProvider;
    private final TargetingMapper targetingMapper;

    @PostMapping("suggest")
    public List<GeoTargetConstantDto> suggest(Principal principal,
                                              @PathVariable long customerId,
                                              @RequestBody @Valid SuggestGeoTargetConstantsRequestDto request)
            throws Exception {
        return targetingMapper.resolve(
                googleAdsDataProvider.targeting().findAll(principal, targetingMapper.resolve(request))
        );
    }
}
