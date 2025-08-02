/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.shared.dao;

import net.twobid.gcrud.GCrudRepository;
import net.twobid.shared.dao.model.ConfigurableServiceEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurableServiceRepository extends GCrudRepository<ConfigurableServiceEntity, String> {
}
