/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.twobid.googleads.dto.KeywordSnapshotUrlDto;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;

@RestController
@RequestMapping("/googleads-api/v1/keywords/snapshot")
@Tag(name = "GoogleAdsKeywordSnapshot", description = "Google Ads Keyword Snapshot API")
public class GoogleAdsAppKeywordSnapshotController {
    private final GoogleAdsDataProvider googleAdsDataProvider;
    private final String baseUrl;

    public GoogleAdsAppKeywordSnapshotController(GoogleAdsDataProvider googleAdsDataProvider,
                                                 @Value("${net.twobid.googleads-api.kwsnapshothost:http://xyz.net}") String baseUrl) {
        this.googleAdsDataProvider = googleAdsDataProvider;
        this.baseUrl = baseUrl;
    }

    @GetMapping("{bundleId}/url")
    public KeywordSnapshotUrlDto keywordSnapshotUrl(@Nonnull @PathVariable("bundleId") String bundleId) throws Exception {
        return new KeywordSnapshotUrlDto().setUrl(googleAdsDataProvider.keywordSnapshot().getSnapshotUrl(baseUrl, bundleId));
    }

    @GetMapping(value = "{bundleId}/{accessKey}", produces = "text/html")
    public ResponseEntity<String> keywordSnapshotOfApp(@Nonnull @PathVariable("bundleId") String bundleId,
                                                       @Nonnull @PathVariable("accessKey") String accessKey) throws Exception {
        return googleAdsDataProvider.keywordSnapshot().snapshot(bundleId, accessKey);
    }
}
