/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.api.googleplayscraper.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class App {
    @JsonProperty("title")
    private String title;
    @JsonProperty("appId")
    private String appId;
    @JsonProperty("url")
    private String url;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("developer")
    private Developer developer;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("free")
    private Boolean free;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("scoreText")
    private String scoreText;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("playstoreUrl")
    private String playstoreUrl;
    @JsonProperty("permissions")
    private String permissions;
    @JsonProperty("similar")
    private String similar;
    @JsonProperty("reviews")
    private String reviews;
    @JsonProperty("datasafety")
    private String datasafety;
    @JsonProperty("categories")
    private String categories;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
