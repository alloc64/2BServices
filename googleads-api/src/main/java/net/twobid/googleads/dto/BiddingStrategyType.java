/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dto;

public enum BiddingStrategyType {
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
     * Commission is an automatic bidding strategy in which the advertiser pays
     * a certain portion of the conversion value.
     * </pre>
     *
     * <code>COMMISSION = 16;</code>
     */
    COMMISSION,
    /**
     * <pre>
     * Enhanced CPC is a bidding strategy that raises bids for clicks
     * that seem more likely to lead to a conversion and lowers
     * them for clicks where they seem less likely.
     * </pre>
     *
     * <code>ENHANCED_CPC = 2;</code>
     */
    ENHANCED_CPC,
    /**
     * <pre>
     * Used for return value only. Indicates that a campaign does not have a
     * bidding strategy. This prevents the campaign from serving. For example,
     * a campaign may be attached to a manager bidding strategy and the serving
     * account is subsequently unlinked from the manager account. In this case
     * the campaign will automatically be detached from the now inaccessible
     * manager bidding strategy and transition to the INVALID bidding strategy
     * type.
     * </pre>
     *
     * <code>INVALID = 17;</code>
     */
    INVALID,
    /**
     * <pre>
     * Manual bidding strategy that allows advertiser to set the bid per
     * advertiser-specified action.
     * </pre>
     *
     * <code>MANUAL_CPA = 18;</code>
     */
    MANUAL_CPA,
    /**
     * <pre>
     * Manual click based bidding where user pays per click.
     * </pre>
     *
     * <code>MANUAL_CPC = 3;</code>
     */
    MANUAL_CPC,
    /**
     * <pre>
     * Manual impression based bidding
     * where user pays per thousand impressions.
     * </pre>
     *
     * <code>MANUAL_CPM = 4;</code>
     */
    MANUAL_CPM,
    /**
     * <pre>
     * A bidding strategy that pays a configurable amount per video view.
     * </pre>
     *
     * <code>MANUAL_CPV = 13;</code>
     */
    MANUAL_CPV,
    /**
     * <pre>
     * A bidding strategy that automatically maximizes number of conversions
     * given a daily budget.
     * </pre>
     *
     * <code>MAXIMIZE_CONVERSIONS = 10;</code>
     */
    MAXIMIZE_CONVERSIONS,
    /**
     * <pre>
     * An automated bidding strategy that automatically sets bids to maximize
     * revenue while spending your budget.
     * </pre>
     *
     * <code>MAXIMIZE_CONVERSION_VALUE = 11;</code>
     */
    MAXIMIZE_CONVERSION_VALUE,
    /**
     * <pre>
     * Page-One Promoted bidding scheme, which sets max cpc bids to
     * target impressions on page one or page one promoted slots on google.com.
     * This enum value is deprecated.
     * </pre>
     *
     * <code>PAGE_ONE_PROMOTED = 5;</code>
     */
    @Deprecated
    PAGE_ONE_PROMOTED,
    /**
     * <pre>
     * Percent Cpc is bidding strategy where bids are a fraction of the
     * advertised price for some good or service.
     * </pre>
     *
     * <code>PERCENT_CPC = 12;</code>
     */
    PERCENT_CPC,
    /**
     * <pre>
     * Target CPA is an automated bid strategy that sets bids
     * to help get as many conversions as possible
     * at the target cost-per-acquisition (CPA) you set.
     * </pre>
     *
     * <code>TARGET_CPA = 6;</code>
     */
    TARGET_CPA,
    /**
     * <pre>
     * Target CPM is an automated bid strategy that sets bids to help get
     * as many impressions as possible at the target cost per one thousand
     * impressions (CPM) you set.
     * </pre>
     *
     * <code>TARGET_CPM = 14;</code>
     */
    TARGET_CPM,
    /**
     * <pre>
     * An automated bidding strategy that sets bids so that a certain percentage
     * of search ads are shown at the top of the first page (or other targeted
     * location).
     * </pre>
     *
     * <code>TARGET_IMPRESSION_SHARE = 15;</code>
     */
    TARGET_IMPRESSION_SHARE,
    /**
     * <pre>
     * Target Outrank Share is an automated bidding strategy that sets bids
     * based on the target fraction of auctions where the advertiser
     * should outrank a specific competitor.
     * This enum value is deprecated.
     * </pre>
     *
     * <code>TARGET_OUTRANK_SHARE = 7;</code>
     */
    @Deprecated
    TARGET_OUTRANK_SHARE,
    /**
     * <pre>
     * Target ROAS is an automated bidding strategy
     * that helps you maximize revenue while averaging
     * a specific target Return On Average Spend (ROAS).
     * </pre>
     *
     * <code>TARGET_ROAS = 8;</code>
     */
    TARGET_ROAS,
    /**
     * <pre>
     * Target Spend is an automated bid strategy that sets your bids
     * to help get as many clicks as possible within your budget.
     * </pre>
     *
     * <code>TARGET_SPEND = 9;</code>
     */
    TARGET_SPEND,
    UNRECOGNIZED;

    public static BiddingStrategyType fromString(String value) {
        for (BiddingStrategyType s : BiddingStrategyType.values()) {
            if (s.name().equalsIgnoreCase(value)) {
                return s;
            }
        }
        return BiddingStrategyType.UNRECOGNIZED;
    }
}
