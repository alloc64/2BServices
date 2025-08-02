/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.provider;

import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.v16.services.*;
import com.google.api.client.auth.oauth2.Credential;
import com.google.auth.oauth2.ClientId;
import com.google.auth.oauth2.UserAuthorizer;
import com.google.auth.oauth2.UserCredentials;
import lombok.extern.slf4j.Slf4j;
import net.twobid.google.oauth2.OAuth2DataProvider;
import net.twobid.google.oauth2.TwobidTokenStore;
import net.twobid.googleads.provider.impl.*;
import net.twobid.googleads.query.QueryBuilder;
import net.twobid.shared.model.PageTokenPage;
import net.twobid.shared.model.PageTokenPageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.security.Principal;
import java.util.*;

@Slf4j
@Component
public class GoogleAdsDataProvider extends OAuth2DataProvider<GoogleAdsClient> {
    private final Long managerAccountId;
    private final String developerToken;
    private final GoogleAdsAccountProvider accountProvider;
    private final GoogleAdsAdGroupProvider adGroupProvider;
    private final GoogleAdsAdAssetsProvider adAssetsProvider;
    private final GoogleAdsBudgetProvider budgetProvider;
    private final GoogleAdsCampaignsProvider campaignsProvider;
    private final GoogleAdsConversionActionProvider conversionProvider;
    private final GoogleAdsKeywordsProvider keywordsProvider;
    private final GoogleAdsAppKeywordSnapshotProvider keywordSnapshotProvider;
    private final GoogleAdsTargetingProvider targetingProvider;

    public Long getManagerAccountId() {
        return managerAccountId;
    }

    public GoogleAdsAccountProvider account() {
        return accountProvider;
    }

    public GoogleAdsAdGroupProvider adGroups() {
        return adGroupProvider;
    }

    public GoogleAdsAdAssetsProvider adAssets() {
        return adAssetsProvider;
    }

    public GoogleAdsBudgetProvider budgets() {
        return budgetProvider;
    }

    public GoogleAdsCampaignsProvider campaigns() {
        return campaignsProvider;
    }

    public GoogleAdsConversionActionProvider conversionActions() {
        return conversionProvider;
    }

    public GoogleAdsKeywordsProvider keywords() {
        return keywordsProvider;
    }

    public GoogleAdsAppKeywordSnapshotProvider keywordSnapshot() {
        return keywordSnapshotProvider;
    }

    public GoogleAdsTargetingProvider targeting() {
        return targetingProvider;
    }

    public GoogleAdsDataProvider(@Value("${google.ads.client.id}") String clientId,
                                 @Value("${google.ads.client.secret}") String clientSecret,
                                 @Value("${google.ads.login.callback.url}") URI loginCallbackUrl,
                                 @Value("${google.ads.managerAccountId}") Long managerAccountId,
                                 @Value("${google.ads.developertoken}") String developerToken,
                                 TwobidTokenStore tokenStore,
                                 GoogleAdsAccountProvider accountProvider,
                                 GoogleAdsAdGroupProvider adGroupProvider,
                                 GoogleAdsAdAssetsProvider adAssetsProvider,
                                 GoogleAdsBudgetProvider budgetProvider,
                                 GoogleAdsCampaignsProvider campaignsProvider,
                                 GoogleAdsConversionActionProvider conversionProvider,
                                 GoogleAdsKeywordsProvider keywordsProvider,
                                 GoogleAdsAppKeywordSnapshotProvider keywordSnapshotProvider,
                                 GoogleAdsTargetingProvider targetingProvider) {
        super(UserAuthorizer.newBuilder()
                .setClientId(ClientId.of(clientId, clientSecret))
                .setScopes(Collections.singletonList("https://www.googleapis.com/auth/adwords"))
                .setCallbackUri(loginCallbackUrl)
                .setTokenStore(tokenStore)
                .build(), tokenStore, loginCallbackUrl);
        this.managerAccountId = managerAccountId;
        this.developerToken = developerToken;
        this.accountProvider = accountProvider.initialize(this);
        this.adGroupProvider = adGroupProvider.initialize(this);
        this.adAssetsProvider = adAssetsProvider.initialize(this);
        this.budgetProvider = budgetProvider.initialize(this);
        this.campaignsProvider = campaignsProvider.initialize(this);
        this.conversionProvider = conversionProvider.initialize(this);
        this.keywordsProvider = keywordsProvider.initialize(this);
        this.targetingProvider = targetingProvider.initialize(this);
        this.keywordSnapshotProvider = keywordSnapshotProvider;
    }

    @Override
    protected String getProviderName() {
        return "google-ads";
    }

    @Override
    protected void doAuthenticate(URI state, String code, GoogleAdsClient client) throws Exception {
        try (CustomerServiceClient customerServiceClient = client
                .getLatestVersion()
                .createCustomerServiceClient()) {

            List<String> customerAccounts = customerServiceClient
                    .listAccessibleCustomers(ListAccessibleCustomersRequest.newBuilder().build())
                    .getResourceNamesList()
                    .stream()
                    .filter(id -> id != null && !id.contains(managerAccountId.toString()))
                    .toList();

            account().saveAccounts(state, customerAccounts);
        }
    }

    @Override
    protected GoogleAdsClient createClient(Credential credential, UserCredentials userCredentials) {
        return GoogleAdsClient.newBuilder()
                .setCredentials(userCredentials)
                .setLoginCustomerId(managerAccountId)
                .setDeveloperToken(developerToken)
                .build();
    }

    public static abstract class ProviderAware<T> {
        private GoogleAdsDataProvider provider;

        public GoogleAdsDataProvider provider() {
            return provider;
        }

        public T initialize(GoogleAdsDataProvider provider) {
            this.provider = provider;
            return (T) this;
        }

        public Iterator<GoogleAdsRow> query(Principal principal, long customerId, String query) throws Exception {
            try (GoogleAdsServiceClient googleAdsServiceClient = provider().createClient(principal)
                    .getLatestVersion()
                    .createGoogleAdsServiceClient()) {
                return googleAdsServiceClient.search(Long.toString(customerId), query)
                        .getPage()
                        .getValues()
                        .iterator();
            }
        }

        public Iterator<GoogleAdsRow> query(Principal principal, long customerId, QueryBuilder query) throws Exception {
            return query(principal, customerId, query.buildQuery());
        }

        public List<GoogleAdsRow> queryList(Principal principal, long customerId, QueryBuilder query) throws Exception {
            List<GoogleAdsRow> list = new ArrayList<>();
            Iterator<GoogleAdsRow> it = query(principal, customerId, query.buildQuery());
            it.forEachRemaining(list::add);
            return list;
        }

        public Optional<GoogleAdsRow> querySingle(Principal principal, long customerId, String query) throws Exception {
            Iterator<GoogleAdsRow> it = query(principal, customerId, query);
            return it.hasNext() ? Optional.ofNullable(it.next()) : Optional.empty();
        }

        public Optional<GoogleAdsRow> querySingle(Principal principal, long customerId, QueryBuilder query) throws Exception {
            return querySingle(principal, customerId, query.buildQuery());
        }

        public <Output> PageTokenPage<Output> queryPaged(Principal principal,
                                                         long customerId,
                                                         QueryBuilder query,
                                                         PageTokenPageable pageable,
                                                         PageTokenPage.ValueMapper<GoogleAdsRow, Output> mapper) throws Exception {
            return queryPaged(principal, customerId, query.buildQuery(), pageable, mapper);
        }

        public <Output> PageTokenPage<Output> queryPaged(Principal principal,
                                                         long customerId,
                                                         String query,
                                                         PageTokenPageable pageable,
                                                         PageTokenPage.ValueMapper<GoogleAdsRow, Output> mapper)
                throws Exception {
            try (GoogleAdsServiceClient googleAdsServiceClient = provider().createClient(principal)
                    .getLatestVersion()
                    .createGoogleAdsServiceClient()) {
                SearchGoogleAdsRequest.Builder builder = SearchGoogleAdsRequest.newBuilder()
                        .setCustomerId(String.valueOf(customerId))
                        .setQuery(query)
                        .setReturnTotalResultsCount(true)
                        .setPageSize(pageable.getPageSize());

                if (pageable.getPageToken() != null)
                    builder.setPageToken(pageable.getPageToken());

                GoogleAdsServiceClient.SearchPage page = googleAdsServiceClient.search(builder.build())
                        .getPage();

                List<Output> list = new ArrayList<>();
                for (var value : page.getValues())
                    list.add(mapper.map(value));

                String nextPageToken = page.getNextPageToken();
                if (StringUtils.isEmpty(nextPageToken))
                    nextPageToken = null;

                return new PageTokenPage<>(list, nextPageToken, page.getResponse().getTotalResultsCount());
            }
        }
    }
}
