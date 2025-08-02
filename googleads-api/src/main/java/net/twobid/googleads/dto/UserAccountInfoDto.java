/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Data
@Jacksonized
public class UserAccountInfoDto {
    private List<CustomerIdEntry> customerIds;

    @Builder
    @Data
    @Jacksonized
    public static class CustomerIdEntry {
        private Long id;
        private boolean markedDefault;
    }
}
