/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dto;

import lombok.Data;

import java.util.List;

@Data
public class AdAssetSaveRequest {
    private Long adId;
    private List<AdAssetDto> assets;
}
