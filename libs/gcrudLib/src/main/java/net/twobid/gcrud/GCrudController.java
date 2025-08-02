/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.gcrud;

import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
public class GCrudController<T extends GCrudEntity<ID>, ID> {
    private final GCrudProvider<T, ID> provider;

    public GCrudProvider<T, ID> getProvider() {
        return provider;
    }

    @GetMapping
    public ResponseEntity<Page<T>> findAll(Principal principal, @ParameterObject Pageable pageable) {
        return ResponseEntity.ok(provider.findAll(principal, pageable));
    }

    @GetMapping({"{id}"})
    public ResponseEntity<T> findById(Principal principal, @PathVariable ID id) {
        return ResponseEntity.ok(provider.findById(principal, id));
    }

    @PostMapping
    public ResponseEntity<T> save(Principal principal, @NonNull @RequestBody T t) {
        return ResponseEntity.ok(provider.save(principal, t));
    }

    @PostMapping("batch")
    public ResponseEntity<Iterable<T>> saveBatch(Principal principal, @NonNull @RequestBody List<T> t) {
        return ResponseEntity.ok(provider.save(principal, t));
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<Void> deleteById(Principal principal, @PathVariable ID id) {
        provider.deleteById(principal, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping({"batch"})
    public ResponseEntity<Void> deleteBatch(Principal principal, @PathVariable Iterable<ID> ids) {
        provider.deleteById(principal, ids);
        return ResponseEntity.noContent().build();
    }
}

