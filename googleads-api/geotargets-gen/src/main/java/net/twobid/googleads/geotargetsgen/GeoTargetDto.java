/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.geotargetsgen;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Data
public class GeoTargetDto {
    private String name;
    private String canonicalName;
    private String countryCode;
    private String resourceName;
    private List<String> languages;

    public GeoTargetDto(GeoTarget g) {
        this.name = g.getName();
        this.canonicalName = g.getCanonicalName();
        this.countryCode = g.getCountryCode();
        this.resourceName = "geoTargetConstants/" + g.getCriteriaId();
    }
}
