/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dto;

public enum ConversionActionType {
    UNSPECIFIED,

    UNKNOWN,

    AD_CALL,

    CLICK_TO_CALL,

    GOOGLE_PLAY_DOWNLOAD,

    GOOGLE_PLAY_IN_APP_PURCHASE,

    UPLOAD_CALLS,

    UPLOAD_CLICKS,

    WEBPAGE,

    WEBSITE_CALL,

    STORE_SALES_DIRECT_UPLOAD,

    STORE_SALES,

    FIREBASE_ANDROID_FIRST_OPEN,

    FIREBASE_ANDROID_IN_APP_PURCHASE,

    FIREBASE_ANDROID_CUSTOM,

    FIREBASE_IOS_FIRST_OPEN,

    FIREBASE_IOS_IN_APP_PURCHASE,

    FIREBASE_IOS_CUSTOM,

    THIRD_PARTY_APP_ANALYTICS_ANDROID_FIRST_OPEN,

    THIRD_PARTY_APP_ANALYTICS_ANDROID_IN_APP_PURCHASE,

    THIRD_PARTY_APP_ANALYTICS_ANDROID_CUSTOM,

    THIRD_PARTY_APP_ANALYTICS_IOS_FIRST_OPEN,

    THIRD_PARTY_APP_ANALYTICS_IOS_IN_APP_PURCHASE,

    THIRD_PARTY_APP_ANALYTICS_IOS_CUSTOM,

    ANDROID_APP_PRE_REGISTRATION,

    ANDROID_INSTALLS_ALL_OTHER_APPS,

    FLOODLIGHT_ACTION,

    FLOODLIGHT_TRANSACTION,

    GOOGLE_HOSTED,

    LEAD_FORM_SUBMIT,

    SALESFORCE,

    SEARCH_ADS_360,

    SMART_CAMPAIGN_AD_CLICKS_TO_CALL,

    SMART_CAMPAIGN_MAP_CLICKS_TO_CALL,

    SMART_CAMPAIGN_MAP_DIRECTIONS,

    SMART_CAMPAIGN_TRACKED_CALLS,

    STORE_VISITS,

    WEBPAGE_CODELESS,

    UNIVERSAL_ANALYTICS_GOAL,

    UNIVERSAL_ANALYTICS_TRANSACTION,

    GOOGLE_ANALYTICS_4_CUSTOM,

    GOOGLE_ANALYTICS_4_PURCHASE,

    UNRECOGNIZED;

    public static ConversionActionType fromString(String value) {
        for (ConversionActionType type : ConversionActionType.values()) {
            if (type.name().equals(value)) {
                return type;
            }
        }
        return UNRECOGNIZED;
    }
}
