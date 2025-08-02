/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.provider.model;

import com.google.ads.googleads.v16.resources.ConversionAction;
import com.google.ads.googleads.v16.resources.GeoTargetConstant;
import com.google.ads.googleads.v16.services.GoogleAdsRow;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Data
public class CampaignDetail {
    private GoogleAdsRow campaign;
    private List<ConversionAction> conversionActions;
    private List<GeoTargetConstant> locationTargetingGeoTargetConstants;
}
