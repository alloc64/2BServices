/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.billing.api;

import net.twobid.client.retrofit.RetrofitApiProvider;
import net.twobid.core.api.AppApi;
import net.twobid.core.api.AppSecureStateApi;
import net.twobid.core.api.CurrencyRateApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class CoreApi extends RetrofitApiProvider {
    public CoreApi(@Value("${net.twobid.host.core-api:http://localhost:3003}") String baseUrl,
                   @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}") String resourceServerHost,
                   @Value("${auth0.audience}") String audience,
                   @Value("${net.twobid.auth.m2.clientid}") String clientId,
                   @Value("${net.twobid.auth.m2.clientsecret}") String clientSecret) {
        super(baseUrl, resourceServerHost, audience, clientId, clientSecret);
    }
    public AppApi app() {
        return get(AppApi.class);
    }

    public AppApi app(Principal principal) {
        return get(AppApi.class, principal);
    }

    public AppSecureStateApi appSecureState() {
        return get(AppSecureStateApi.class);
    }

    public CurrencyRateApi currencyRate() {
        return get(CurrencyRateApi.class);
    }
}
