/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dto;

public enum AssetPerformanceLabel {
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
     * This asset does not yet have any performance informantion. This may be
     * because it is still under review.
     * </pre>
     *
     * <code>PENDING = 2;</code>
     */
    PENDING,
    /**
     * <pre>
     * The asset has started getting impressions but the stats are not
     * statistically significant enough to get an asset performance label.
     * </pre>
     *
     * <code>LEARNING = 3;</code>
     */
    LEARNING,
    /**
     * <pre>
     * Worst performing assets.
     * </pre>
     *
     * <code>LOW = 4;</code>
     */
    LOW,
    /**
     * <pre>
     * Good performing assets.
     * </pre>
     *
     * <code>GOOD = 5;</code>
     */
    GOOD,
    /**
     * <pre>
     * Best performing assets.
     * </pre>
     *
     * <code>BEST = 6;</code>
     */
    BEST,
    UNRECOGNIZED;

    public static AssetPerformanceLabel fromString(String status) {
        for (AssetPerformanceLabel s : AssetPerformanceLabel.values()) {
            if (s.name().equalsIgnoreCase(status)) {
                return s;
            }
        }
        return AssetPerformanceLabel.UNRECOGNIZED;
    }
}
