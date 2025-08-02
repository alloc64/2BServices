/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.google.oauth2;

import lombok.Data;
import lombok.experimental.Accessors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "token_store")
public class TokenStoreEntity {
    @Id
    private String userId;
    @Column(length = 8192)
    private String tokens;
    @Column(columnDefinition = "json")
    private String customData;
}
