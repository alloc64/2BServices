/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.twobid.googleads.dto.AccountInfoDto;
import net.twobid.googleads.dto.UserAccountInfoDto;
import net.twobid.googleads.mapper.AccountMapper;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/googleads-api/v1/account")
@Tag(name = "GoogleAdsAccount", description = "Google Ads Account API")
public class GoogleAdsAccountController {
    private final AccountMapper accountMapper;
    private final GoogleAdsDataProvider googleAdsDataProvider;

    @GetMapping
    public UserAccountInfoDto findAll(Principal principal) throws Exception {
        return googleAdsDataProvider.account().findAll(principal);
    }

    @GetMapping("default")
    public Long findDefault(Principal principal) throws Exception {
        return googleAdsDataProvider.account()
                .findDefault(principal)
                .orElseThrow(() -> new NoSuchElementException("Default account not found."));
    }

    @PostMapping("{customerId}/default")
    public UserAccountInfoDto markDefault(Principal principal, @PathVariable long customerId) throws Exception {
        return googleAdsDataProvider.account().markDefault(principal, customerId);
    }

    @GetMapping("{customerId}/balance")
    public AccountInfoDto accountBalance( Principal principal, @PathVariable long customerId) throws Exception {
        return accountMapper.resolve(googleAdsDataProvider.account().balance(principal, customerId));
    }
}
