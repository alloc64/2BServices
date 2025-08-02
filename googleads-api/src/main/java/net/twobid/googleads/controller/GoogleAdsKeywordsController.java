/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.controller;

import com.google.ads.googleads.v16.common.KeywordPlanHistoricalMetrics;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.twobid.googleads.dto.KeywordIdeasRequestDto;
import net.twobid.googleads.dto.KeywordMetricDto;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/googleads-api/v1/keywords")
@Tag(name = "GoogleAdsKeywords", description = "Google Ads Keywords API")
public class GoogleAdsKeywordsController {
    private final GoogleAdsDataProvider googleAdsDataProvider;

    @PostMapping( "ideas")
    public List<KeywordMetricDto> keywordIdeas(Principal principal, @RequestBody @Valid KeywordIdeasRequestDto request)
            throws Exception {
        List<KeywordMetricDto> result = new ArrayList<>();
        googleAdsDataProvider.keywords().keywordIdeas(principal, request).forEach(kw -> {
            KeywordPlanHistoricalMetrics metrics = kw.getKeywordIdeaMetrics();
            result.add(KeywordMetricDto.builder()
                    .keyword(kw.getText())
                    .keywordVariants(kw.getCloseVariantsList())
                    .avgMonthlySearches(metrics.getAvgMonthlySearches())
                    .competitionIndex(metrics.getCompetitionIndex())
                    .highTopOfPageBidMicros(metrics.getHighTopOfPageBidMicros())
                    .lowTopOfPageBidMicros(metrics.getLowTopOfPageBidMicros())
                    .build());
        });

        return result;
    }

    @PostMapping("historical-metrics")
    public List<KeywordMetricDto> historicalMetrics(Principal principal, @RequestBody @Valid List<String> keywords)
            throws Exception {
        return googleAdsDataProvider.keywords().historicalMetrics(principal, keywords)
                .getResultsList()
                .parallelStream()
                .map(r -> KeywordMetricDto.builder()
                        .keyword(r.getText())
                        .keywordVariants(r.getCloseVariantsList())
                        .avgMonthlySearches(r.getKeywordMetrics().getAvgMonthlySearches())
                        .competitionIndex(r.getKeywordMetrics().getCompetitionIndex())
                        .highTopOfPageBidMicros(r.getKeywordMetrics().getHighTopOfPageBidMicros())
                        .lowTopOfPageBidMicros(r.getKeywordMetrics().getLowTopOfPageBidMicros())
                        .build())
                .collect(Collectors.toList());
    }
}
