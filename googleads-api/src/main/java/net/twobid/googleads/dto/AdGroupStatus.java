/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dto;

public enum AdGroupStatus {
    /**
     * <pre>
     * The status has not been specified.
     * </pre>
     *
     * <code>UNSPECIFIED = 0;</code>
     */
    UNSPECIFIED,
    /**
     * <pre>
     * The received value is not known in this version.
     * This is a response-only value.
     * </pre>
     *
     * <code>UNKNOWN = 1;</code>
     */
    UNKNOWN,
    /**
     * <pre>
     * The ad group is enabled.
     * </pre>
     *
     * <code>ENABLED = 2;</code>
     */
    ENABLED,
    /**
     * <pre>
     * The ad group is paused.
     * </pre>
     *
     * <code>PAUSED = 3;</code>
     */
    PAUSED,
    /**
     * <pre>
     * The ad group is removed.
     * </pre>
     *
     * <code>REMOVED = 4;</code>
     */
    REMOVED,
    UNRECOGNIZED;

    public static AdGroupStatus fromString(String status) {
        for (AdGroupStatus s : AdGroupStatus.values()) {
            if (s.name().equalsIgnoreCase(status)) {
                return s;
            }
        }
        return AdGroupStatus.UNRECOGNIZED;
    }
}
