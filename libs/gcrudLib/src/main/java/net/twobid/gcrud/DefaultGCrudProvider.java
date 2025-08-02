/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.gcrud;

import lombok.RequiredArgsConstructor;
import net.twobid.gcrud.exceptions.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.security.Principal;

/**
 * Given, that our endpoint is named /api/v1/todos, these defined endpoints will be defined automatically:
 * <p>
 * GET /api/v1/todos
 * Retrieves all resources from our database. Supports pagination.
 * </p>
 * <p>
 * GET /api/v1/todos/:id
 * Retrieves one resource.
 * </p>
 * <p>
 * POST /api/v1/todos
 * Creates a new resource.
 * </p>
 * <p>
 * PUT /api/v1/todos/:id
 * Updates a resource. The whole resource needs to be provided. Missing fields will be set to null.
 * </p>
 */
@RequiredArgsConstructor
public class DefaultGCrudProvider<T extends GCrudEntity<ID>, ID> implements GCrudProvider<T, ID> {
    private final GCrudRepository<T, ID> repository;

    @Override
    public Page<T> findAll(Principal principal, Pageable pageable) {
        if(pageable == null)
            return new PageImpl<>(repository.findAll());

        return repository.findAll(pageable);
    }

    @Override
    public T findById(Principal principal, ID id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public T save(Principal principal, T entity) {
        return repository.save(entity);
    }

    @Override
    public Iterable<T> save(Principal principal, Iterable<T> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public void deleteById(Principal principal, ID id) {
        checkIfExists(id);
        repository.deleteById(id);
    }

    @Override
    public void deleteById(Principal principal, Iterable<ID> ids) {
        repository.deleteAllById(ids);
    }

    private void checkIfExists(ID id) {
        if (!repository.existsById(id))
            throw new EntityNotFoundException();
    }
}
