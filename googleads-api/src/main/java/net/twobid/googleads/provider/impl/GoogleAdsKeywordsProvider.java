/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.provider.impl;

import com.google.ads.googleads.v16.enums.KeywordPlanNetworkEnum;
import com.google.ads.googleads.v16.services.*;
import lombok.RequiredArgsConstructor;
import net.twobid.googleads.dto.KeywordIdeasRequestDto;
import net.twobid.googleads.exceptions.GoogleAdsAuthException;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class GoogleAdsKeywordsProvider extends GoogleAdsDataProvider.ProviderAware<GoogleAdsKeywordsProvider> {
    public Iterable<GenerateKeywordIdeaResult> keywordIdeas(Principal principal, KeywordIdeasRequestDto request) throws Exception {
        try (KeywordPlanIdeaServiceClient keywordPlanServiceClient = provider().createClient(principal)
                .getLatestVersion()
                .createKeywordPlanIdeaServiceClient()) {
            return keywordPlanServiceClient.generateKeywordIdeas(GenerateKeywordIdeasRequest.newBuilder()
                            .setCustomerId(String.valueOf(provider().getManagerAccountId()))
                            .setUrlSeed(UrlSeed.newBuilder().setUrl(request.getUrl()).build())
                            .addAllGeoTargetConstants(resolveCountryCodeToCriteriaId(principal, request.getCountryCodes()))
                            .setKeywordPlanNetwork(KeywordPlanNetworkEnum.KeywordPlanNetwork.GOOGLE_SEARCH_AND_PARTNERS)
                            .build())
                    .iterateAll();
        } catch (Exception e) {
            throw new GoogleAdsAuthException(e);
        }
    }

    public GenerateKeywordHistoricalMetricsResponse historicalMetrics(Principal principal, List<String> keywords) throws Exception {
        try (KeywordPlanIdeaServiceClient keywordPlanServiceClient = provider().createClient(principal)
                .getLatestVersion()
                .createKeywordPlanIdeaServiceClient()) {

            return keywordPlanServiceClient.generateKeywordHistoricalMetrics(
                    GenerateKeywordHistoricalMetricsRequest.newBuilder()
                            .addAllKeywords(keywords)
                            .setCustomerId(String.valueOf(provider().getManagerAccountId()))
                            .build()
            );
        } catch (Exception e) {
            throw new GoogleAdsAuthException(e);
        }
    }

    private List<String> resolveCountryCodeToCriteriaId(Principal principal, List<String> countryCodes) throws Exception {
        if (countryCodes.size() > 10)
            throw new IllegalStateException("Country codes count must be less than 10");

        try (GeoTargetConstantServiceClient geoTargetClient = provider().createClient(principal).getLatestVersion()
                .createGeoTargetConstantServiceClient()) {
            List<String> list = geoTargetClient
                    .suggestGeoTargetConstants(SuggestGeoTargetConstantsRequest.newBuilder()
                            .setLocale("en")
                            .setLocationNames(SuggestGeoTargetConstantsRequest.LocationNames.newBuilder()
                                    .addAllNames(countryCodes)
                                    .build())
                            .build())
                    .getGeoTargetConstantSuggestionsList()
                    .stream()
                    .filter(x -> "Country".equals(x.getGeoTargetConstant().getTargetType()))
                    .map(x -> x.getGeoTargetConstant().getResourceName())
                    .toList();

            if(list.isEmpty())
                throw new NoSuchElementException("No criteria id found for country code %s".formatted(String.join(",", countryCodes)));

            return list;
        }
    }
}
