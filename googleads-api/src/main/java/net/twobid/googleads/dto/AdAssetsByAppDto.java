/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
public class AdAssetsByAppDto {
    private String packageName;
    private List<CampaignDto> campaigns;
    private Map<Long, List<AdAssetDto>> assetsByCampaignId = new LinkedHashMap<>();
}
