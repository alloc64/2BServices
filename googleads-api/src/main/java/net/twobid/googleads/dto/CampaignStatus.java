/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dto;

public enum CampaignStatus {
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
     * Campaign is currently serving ads depending on budget information.
     * </pre>
     *
     * <code>ENABLED = 2;</code>
     */
    ENABLED,
    /**
     * <pre>
     * Campaign has been paused by the user.
     * </pre>
     *
     * <code>PAUSED = 3;</code>
     */
    PAUSED,
    /**
     * <pre>
     * Campaign has been removed.
     * </pre>
     *
     * <code>REMOVED = 4;</code>
     */
    REMOVED,
    UNRECOGNIZED;

    public static CampaignStatus fromString(String status) {
        for (CampaignStatus s : CampaignStatus.values()) {
            if (s.name().equalsIgnoreCase(status)) {
                return s;
            }
        }
        return CampaignStatus.UNRECOGNIZED;
    }
}
