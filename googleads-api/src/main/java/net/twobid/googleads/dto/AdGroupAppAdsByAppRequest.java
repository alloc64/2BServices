/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class AdGroupAppAdsByAppRequest {
    private FindAllCampaignsRequestDto campaignsFilter;
    private List<AssetPerformanceLabel> performanceLabels = new ArrayList<>();
}
