/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.geotargetsgen;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GeoTarget {
    @JsonProperty("criteriaId")
    private int criteriaId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("canonicalName")
    private String canonicalName;

    @JsonProperty("countryCode")
    private String countryCode;

    @JsonProperty("targetType")
    private String targetType;

    @JsonProperty("parentId")
    private int parentId;

    @JsonProperty("status")
    private String status;
}
