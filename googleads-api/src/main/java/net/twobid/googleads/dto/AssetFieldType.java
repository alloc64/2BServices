/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dto;

public enum AssetFieldType {
    /**
     * <pre>
     * Not specified.
     * </pre>
     *
     * <code>UNSPECIFIED = 0;</code>
     */
    UNSPECIFIED,
    /**
     * <pre>
     * Used for return value only. Represents value unknown in this version.
     * </pre>
     *
     * <code>UNKNOWN = 1;</code>
     */
    UNKNOWN,
    /**
     * <pre>
     * The asset is linked for use as a headline.
     * </pre>
     *
     * <code>HEADLINE = 2;</code>
     */
    HEADLINE,
    /**
     * <pre>
     * The asset is linked for use as a description.
     * </pre>
     *
     * <code>DESCRIPTION = 3;</code>
     */
    DESCRIPTION,
    /**
     * <pre>
     * The asset is linked for use as mandatory ad text.
     * </pre>
     *
     * <code>MANDATORY_AD_TEXT = 4;</code>
     */
    MANDATORY_AD_TEXT,
    /**
     * <pre>
     * The asset is linked for use as a marketing image.
     * </pre>
     *
     * <code>MARKETING_IMAGE = 5;</code>
     */
    MARKETING_IMAGE,
    /**
     * <pre>
     * The asset is linked for use as a media bundle.
     * </pre>
     *
     * <code>MEDIA_BUNDLE = 6;</code>
     */
    MEDIA_BUNDLE,
    /**
     * <pre>
     * The asset is linked for use as a YouTube video.
     * </pre>
     *
     * <code>YOUTUBE_VIDEO = 7;</code>
     */
    YOUTUBE_VIDEO,
    /**
     * <pre>
     * The asset is linked to indicate that a hotels campaign is "Book on
     * Google" enabled.
     * </pre>
     *
     * <code>BOOK_ON_GOOGLE = 8;</code>
     */
    BOOK_ON_GOOGLE,
    /**
     * <pre>
     * The asset is linked for use as a Lead Form extension.
     * </pre>
     *
     * <code>LEAD_FORM = 9;</code>
     */
    LEAD_FORM,
    /**
     * <pre>
     * The asset is linked for use as a Promotion extension.
     * </pre>
     *
     * <code>PROMOTION = 10;</code>
     */
    PROMOTION,
    /**
     * <pre>
     * The asset is linked for use as a Callout extension.
     * </pre>
     *
     * <code>CALLOUT = 11;</code>
     */
    CALLOUT,
    /**
     * <pre>
     * The asset is linked for use as a Structured Snippet extension.
     * </pre>
     *
     * <code>STRUCTURED_SNIPPET = 12;</code>
     */
    STRUCTURED_SNIPPET,
    /**
     * <pre>
     * The asset is linked for use as a Sitelink extension.
     * </pre>
     *
     * <code>SITELINK = 13;</code>
     */
    SITELINK,
    /**
     * <pre>
     * The asset is linked for use as a Mobile App extension.
     * </pre>
     *
     * <code>MOBILE_APP = 14;</code>
     */
    MOBILE_APP,
    /**
     * <pre>
     * The asset is linked for use as a Hotel Callout extension.
     * </pre>
     *
     * <code>HOTEL_CALLOUT = 15;</code>
     */
    HOTEL_CALLOUT,
    /**
     * <pre>
     * The asset is linked for use as a Call extension.
     * </pre>
     *
     * <code>CALL = 16;</code>
     */
    CALL,
    /**
     * <pre>
     * The asset is linked for use as a Price extension.
     * </pre>
     *
     * <code>PRICE = 24;</code>
     */
    PRICE,
    /**
     * <pre>
     * The asset is linked for use as a long headline.
     * </pre>
     *
     * <code>LONG_HEADLINE = 17;</code>
     */
    LONG_HEADLINE,
    /**
     * <pre>
     * The asset is linked for use as a business name.
     * </pre>
     *
     * <code>BUSINESS_NAME = 18;</code>
     */
    BUSINESS_NAME,
    /**
     * <pre>
     * The asset is linked for use as a square marketing image.
     * </pre>
     *
     * <code>SQUARE_MARKETING_IMAGE = 19;</code>
     */
    SQUARE_MARKETING_IMAGE,
    /**
     * <pre>
     * The asset is linked for use as a portrait marketing image.
     * </pre>
     *
     * <code>PORTRAIT_MARKETING_IMAGE = 20;</code>
     */
    PORTRAIT_MARKETING_IMAGE,
    /**
     * <pre>
     * The asset is linked for use as a logo.
     * </pre>
     *
     * <code>LOGO = 21;</code>
     */
    LOGO,
    /**
     * <pre>
     * The asset is linked for use as a landscape logo.
     * </pre>
     *
     * <code>LANDSCAPE_LOGO = 22;</code>
     */
    LANDSCAPE_LOGO,
    /**
     * <pre>
     * The asset is linked for use as a non YouTube logo.
     * </pre>
     *
     * <code>VIDEO = 23;</code>
     */
    VIDEO,
    /**
     * <pre>
     * The asset is linked for use to select a call-to-action.
     * </pre>
     *
     * <code>CALL_TO_ACTION_SELECTION = 25;</code>
     */
    CALL_TO_ACTION_SELECTION,
    /**
     * <pre>
     * The asset is linked for use to select an ad image.
     * </pre>
     *
     * <code>AD_IMAGE = 26;</code>
     */
    AD_IMAGE,
    UNRECOGNIZED;

    public static AssetFieldType fromString(String status) {
        for (AssetFieldType s : AssetFieldType.values()) {
            if (s.name().equalsIgnoreCase(status)) {
                return s;
            }
        }
        return AssetFieldType.UNRECOGNIZED;
    }
}
