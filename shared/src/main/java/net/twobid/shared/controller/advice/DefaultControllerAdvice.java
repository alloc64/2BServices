/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.shared.controller.advice;

import net.twobid.shared.auth.AuthenticationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class DefaultControllerAdvice {
    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    public final ResponseEntity<String> handle(SQLIntegrityConstraintViolationException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
    @ExceptionHandler({NoSuchElementException.class})
    public final ResponseEntity<String> handle(NoSuchElementException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(StringUtils.isEmpty(ex.getMessage()) ? "Item does not exists." : ex.getMessage());
    }
    @ExceptionHandler({AuthenticationException.class})
    public final ResponseEntity<String> handle(AuthenticationException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    @ExceptionHandler({ResponseStatusException.class})
    public final ResponseEntity<String> handle(ResponseStatusException ex, WebRequest request) {
        return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
    }
}
