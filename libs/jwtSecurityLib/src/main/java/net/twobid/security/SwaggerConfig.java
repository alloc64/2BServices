/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.security;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SwaggerConfig {
    public SwaggerConfig() {
        System.setProperty("springdoc.swagger-ui.persistAuthorization", String.valueOf(true));
    }

    @Bean
    public OpenAPI oauth2OpenApi(@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}") String resourceServerHost,
                                 @Value("${auth0.audience}") String audience) {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("oauth2", new SecurityScheme()
                                .bearerFormat("JWT")
                                .type(SecurityScheme.Type.OAUTH2)
                                .flows(new OAuthFlows().implicit(new OAuthFlow()
                                        .tokenUrl(resourceServerHost + "oauth/token")
                                        .authorizationUrl(resourceServerHost + "authorize?audience=" + audience)
                                        .scopes(new Scopes()
                                                .addString("openid", "openid")
                                                .addString("profile", "profile")
                                                .addString("email", "email"))))))
                .addSecurityItem(new SecurityRequirement().addList("oauth2"));
    }
}
