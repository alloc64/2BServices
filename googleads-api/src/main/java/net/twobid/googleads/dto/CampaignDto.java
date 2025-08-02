/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class CampaignDto {
    private Long id;
    private long customerId;
    private String accountCurrencyCode;
    private String name;
    private long budget;
    private String startDate;
    private String endDate;
    private CampaignStatus status;
    private BiddingStrategyType biddingStrategyType;
    private LocationTargetingDto locationTargeting;
    private List<ConversionActionDto> conversionActions;
    private TargetCpa targetCpa;
    private MaximizeConversionsTargetCpa maximizeConversionsTargetCpa;
    private MaximizeConversionValue maximizeConversionValue;
    private TargetRoas targetRoas;
    private String packageName;
    private Double score;

    @Data
    public static class TargetCpa {
        private long micros;
    }

    @Data
    public static class MaximizeConversionsTargetCpa {
        private long micros;
    }

    @Data
    public static class MaximizeConversionValue {
        private double value;
    }

    @Data
    public static class TargetRoas {
        private double roas;
    }
}
