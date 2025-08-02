/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.security;

import net.twobid.security.DefaultSecurityConfig;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableWebSecurity
public class SecurityConfig extends DefaultSecurityConfig {
    public SecurityConfig(OAuth2TokenValidator<Jwt> audienceValidator) {
        super(audienceValidator);
    }
    @Override
    protected List<String> unprotectedUrls() {
        return List.of("/googleads-api/v1/auth", "/googleads-api/v1/keywords/snapshot/**");
    }
}
