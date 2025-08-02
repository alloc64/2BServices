/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.google.oauth2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenStoreRepository extends JpaRepository<TokenStoreEntity, String> {
}
