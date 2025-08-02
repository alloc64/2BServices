/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AdAssetDto {
    private Long id;
    private String text;
    private String youtubeVideoId;
    @NotNull
    private AssetFieldType fieldType;
    private AssetPerformanceLabel performanceLabel;
}

