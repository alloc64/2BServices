/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.api.googleplayscraper.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AppDetail {
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("descriptionHTML")
    private String descriptionHTML;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("installs")
    private String installs;
    @JsonProperty("minInstalls")
    private Long minInstalls;
    @JsonProperty("maxInstalls")
    private Long maxInstalls;
    @JsonProperty("score")
    private Double score;
    @JsonProperty("scoreText")
    private String scoreText;
    @JsonProperty("ratings")
    private Long ratings;
    @JsonProperty("reviews")
    private String reviews;
    @JsonProperty("histogram")
    private Histogram histogram;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("free")
    private Boolean free;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("priceText")
    private String priceText;
    @JsonProperty("available")
    private Boolean available;
    @JsonProperty("offersIAP")
    private Boolean offersIAP;
    @JsonProperty("androidVersion")
    private String androidVersion;
    @JsonProperty("androidVersionText")
    private String androidVersionText;
    @JsonProperty("developer")
    private Developer developer;
    @JsonProperty("developerId")
    private String developerId;
    @JsonProperty("developerEmail")
    private String developerEmail;
    @JsonProperty("developerWebsite")
    private String developerWebsite;
    @JsonProperty("privacyPolicy")
    private String privacyPolicy;
    @JsonProperty("developerInternalID")
    private String developerInternalID;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("genreId")
    private String genreId;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("headerImage")
    private String headerImage;
    @JsonProperty("screenshots")
    private List<String> screenshots = null;
    @JsonProperty("video")
    private String video;
    @JsonProperty("videoImage")
    private String videoImage;
    @JsonProperty("contentRating")
    private String contentRating;
    @JsonProperty("adSupported")
    private Boolean adSupported;
    @JsonProperty("released")
    private String released;
    @JsonProperty("updated")
    private Long updated;
    @JsonProperty("version")
    private String version;
    @JsonProperty("recentChanges")
    private String recentChanges;
    @JsonProperty("comments")
    private List<Object> comments = null;
    @JsonProperty("appId")
    private String appId;
    @JsonProperty("url")
    private String url;
    @JsonProperty("playstoreUrl")
    private String playstoreUrl;
    @JsonProperty("permissions")
    private String permissions;
    @JsonProperty("similar")
    private String similar;
    @JsonProperty("datasafety")
    private String datasafety;
    @JsonProperty("categories")
    private String categories;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
