/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.twobid.security.servlet.CachedBodyHttpServletRequest;
import net.twobid.shared.env.EnvironmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public abstract class DefaultSecurityConfig implements WebMvcConfigurer {
    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuer;

    @Value("${spring.profiles.active:" + EnvironmentType.DEVELOPMENT + "}")
    @Getter
    private String environment;

    private final OAuth2TokenValidator<Jwt> audienceValidator;

    @Autowired
    private SecureStateValidator secureStateValidator;

    @Bean
    public DefaultSecurityFilterChain createFilterChain(HttpSecurity http) throws Exception {
        List<String> unprotectedUrls = new ArrayList<>(unprotectedUrls());

        if (!environment.equals(EnvironmentType.PRODUCTION))
            unprotectedUrls.addAll(List.of("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**"));

        http.sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests
                            .requestMatchers(unprotectedUrls.toArray(new String[0])).permitAll()
                            .anyRequest().authenticated();
                })
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    corsConfiguration.addAllowedMethod(HttpMethod.GET);
                    corsConfiguration.addAllowedMethod(HttpMethod.POST);
                    corsConfiguration.addAllowedMethod(HttpMethod.PUT);
                    corsConfiguration.addAllowedMethod(HttpMethod.PATCH);
                    corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
                    corsConfiguration.addAllowedOriginPattern("*");
                    corsConfiguration.addAllowedHeader("*");
                    return corsConfiguration;
                }))
                .oauth2ResourceServer(oauth2ResourceServer -> {
                    oauth2ResourceServer.jwt((jwt) -> {
                    });
                });

        return http.build();
    }

    @Bean
    public FilterRegistrationBean<CachedBodyHttpServletRequest.Filter> secureStateCachedRequestBodyFilter() {
        FilterRegistrationBean<CachedBodyHttpServletRequest.Filter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new CachedBodyHttpServletRequest.Filter());
        registrationBean.setUrlPatterns(secureValidatorProtectedUrls()
                .stream()
                .map(s -> s.replace("**", "*"))
                .toList());
        registrationBean.setOrder(0);

        return registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(secureStateValidator).addPathPatterns(secureValidatorProtectedUrls());
    }

    protected abstract List<String> unprotectedUrls();

    protected List<String> secureValidatorProtectedUrls() {
        // by default used on all public endpoints specified by unprotectedUrls() are protected with secure validator (they are accessed from the outside, e.g. SDKs, mobile apps, etc.)
        // override this method to use on a different set of endpoints
        return unprotectedUrls();
    }

    @Bean
    JwtDecoder jwtDecoder() {
        NimbusJwtDecoder jwtDecoder = JwtDecoders.fromOidcIssuerLocation(issuer);
        jwtDecoder.setJwtValidator(new DelegatingOAuth2TokenValidator<>(JwtValidators.createDefaultWithIssuer(issuer), audienceValidator));
        return jwtDecoder;
    }
}
