/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.api;

import net.twobid.client.retrofit.RetrofitApiProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class GoogleAdsApi extends RetrofitApiProvider {
    public GoogleAdsApi(@Value("${net.twobid.host.googleads-api:http://localhost:3008}") String baseUrl,
                        @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}") String resourceServerHost,
                        @Value("${auth0.audience}") String audience,
                        @Value("${net.twobid.auth.m2.clientid}") String clientId,
                        @Value("${net.twobid.auth.m2.clientsecret}") String clientSecret) {
        super(baseUrl, resourceServerHost, audience, clientId, clientSecret);
    }

    public GoogleAdsAccountApi account() {
        return get(GoogleAdsAccountApi.class);
    }

    public GoogleAdsAccountApi account(Principal principal) {
        return get(GoogleAdsAccountApi.class, principal);
    }

    public GoogleAdsCampaignsApi campaigns() {
        return get(GoogleAdsCampaignsApi.class);
    }

    public GoogleAdsCampaignsApi campaigns(Principal principal) {
        return get(GoogleAdsCampaignsApi.class, principal);
    }

    public GoogleAdsKeywordsApi keywords() {
        return get(GoogleAdsKeywordsApi.class);
    }

    public GoogleAdsKeywordsApi keywords(Principal principal) {
        return get(GoogleAdsKeywordsApi.class, principal);
    }

    public GoogleAdsKeywordSnapshotApi keywordSnapshot() {
        return get(GoogleAdsKeywordSnapshotApi.class);
    }

    public GoogleAdsKeywordSnapshotApi keywordSnapshot(Principal principal) {
        return get(GoogleAdsKeywordSnapshotApi.class, principal);
    }
}
