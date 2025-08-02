/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.provider.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.twobid.api.googleplayscraper.GooglePlayScraperApi;
import net.twobid.api.googleplayscraper.model.AppDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class GoogleAdsAppKeywordSnapshotProvider {
    private final GooglePlayScraperApi googlePlayScraperApi;

    public String getSnapshotUrl(String baseUrl, String bundleId) {
        return baseUrl + "/googleads-api/v1/keywords/snapshot/{bundleId}/{accessKey}"
                .replace("{bundleId}", bundleId).replace("{accessKey}", "internal");
    }

    public ResponseEntity<String> snapshot(String bundleId, String accessKey) {
        try {
            AppDetail appDetail = googlePlayScraperApi.appDetail(bundleId).blockingSingle();

            return ResponseEntity.ok("""
                    <!DOCTYPE html>
                    <html lang="en">
                      <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <meta http-equiv="X-UA-Compatible" content="ie=edge">
                        <title>{title}</title>
                      </head>
                      <body>
                        <main>
                            <h1>{title}</h1>
                            <h2>{subtitle}</h2>
                            <p>{description}</p>
                        </main>
                      </body>
                    </html>
                    """.replace("{title}", appDetail.getTitle())
                            .replace("{subtitle}", appDetail.getSummary())
                            .replace("{description}", appDetail.getDescriptionHTML()));
        } catch (Exception e) {
            log.error("Failed to retrieve Google Play detail of {} for keyword snapshot.", bundleId, e);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
