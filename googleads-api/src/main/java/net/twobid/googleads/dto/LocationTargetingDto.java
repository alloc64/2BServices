/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Data
public class LocationTargetingDto {
    private List<GeoTargetConstantDto> geoTargetConstants;
}
