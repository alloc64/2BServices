/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.gcrud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;

public interface GCrudProvider<T extends GCrudEntity<ID>, ID> {

    Page<T> findAll(Principal principal, Pageable pageable);

    T findById(Principal principal, ID id);

    T save(Principal principal, T entity);

    Iterable<T> save(Principal principal, Iterable<T> entities);

    void deleteById(Principal principal, ID id);

    void deleteById(Principal principal, Iterable<ID> ids);
}
