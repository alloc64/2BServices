/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.gcrud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GCrudRepository<T extends GCrudEntity<S>, S> extends JpaRepository<T, S> {

}
