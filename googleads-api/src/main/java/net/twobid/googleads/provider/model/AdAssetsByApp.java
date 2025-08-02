/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.provider.model;

import com.google.ads.googleads.v16.services.GoogleAdsRow;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class AdAssetsByApp {
    private String packageName;
    private Long customerId;
    private Long campaignId;
    private Long adGroupId;
    private List<GoogleAdsRow> campaigns;
    private List<GoogleAdsRow> assets;
}
