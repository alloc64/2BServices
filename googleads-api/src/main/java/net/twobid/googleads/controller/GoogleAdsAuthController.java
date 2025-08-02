/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import net.twobid.shared.model.LoginRedirectDto;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import java.net.URI;
import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping("/googleads-api/v1")
@Tag(name = "GoogleAdsAuth" , description = "Google Ads Auth API")
public class GoogleAdsAuthController {
    private final GoogleAdsDataProvider googleAdsDataProvider;

    @GetMapping("login-redirect")
    public LoginRedirectDto loginRedirect(Principal principal, @Nonnull @Param("redirectUrl") String redirectUrl) {
        return new LoginRedirectDto(googleAdsDataProvider.createAuthUrl(principal, redirectUrl).toString());
    }

    @GetMapping("auth")
    public ResponseEntity<Void> authenticate(@Nonnull @Param("state") URI state, @Nonnull @Param("code") String code)
            throws Exception {
        return googleAdsDataProvider.authenticate(state, code);
    }
}
