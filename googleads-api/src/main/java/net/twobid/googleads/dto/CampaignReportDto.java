/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class CampaignReportDto {
    private LocalDate date;
    private Long customerId;
    private Long campaignId;
    private String name;
    private String packageName;
    private String country;
    private long impressions;
    private long clicks;
    private double ctr;
    private double conversions;
    private double conversionValue;
    private double viewThroughConversions;
    private double conversionRate;
    private double cost;
    private String currency;
}
