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

@Jacksonized
@Builder
@Data
public class KeywordMetricDto {
    private String keyword;
    private List<String> keywordVariants;
    private Long avgMonthlySearches;
    private Long competitionIndex;
    private Long lowTopOfPageBidMicros;
    private Long highTopOfPageBidMicros;
}
