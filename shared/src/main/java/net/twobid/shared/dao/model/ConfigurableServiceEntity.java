/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.shared.dao.model;

import lombok.Data;
import lombok.experimental.Accessors;
import net.twobid.gcrud.GCrudEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "configurable_service")
public class ConfigurableServiceEntity implements GCrudEntity<String> {
    @Id
    private String id;
    private boolean enabled;
    private String serviceUserId;
    @Column(columnDefinition = "json")
    private String customData;
}
