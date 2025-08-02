/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(
        name = "googleads_custom_conversion_action",
        indexes = {
                @Index(name = "userIdCustomerId", columnList = "userId,customerId"),
                @Index(name = "idBundleId,UserIdCustomerId", columnList = "id,bundleId,userId,customerId", unique = true),
        })
public class CustomConversionActionEntity {
    @Id
    private Long id;
    private String bundleId;
    private Long customerId;
    private String userId;
    private String name;
    private String type;

    public CustomConversionActionEntity() {

    }
}
