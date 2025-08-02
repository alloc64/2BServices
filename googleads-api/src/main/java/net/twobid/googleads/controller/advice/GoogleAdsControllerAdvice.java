/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.controller.advice;

import com.google.ads.googleads.v15.errors.GoogleAdsException;
import com.google.ads.googleads.v15.errors.GoogleAdsFailure;
import com.google.api.client.http.HttpResponseException;
import net.twobid.googleads.exceptions.GoogleAdsAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Component
@ControllerAdvice
public class GoogleAdsControllerAdvice {
    @ExceptionHandler({GoogleAdsAuthException.class})
    public final ResponseEntity<String> handle(GoogleAdsAuthException ex, WebRequest request) {
        if(ex.getCause() instanceof HttpResponseException httpException)
            return ResponseEntity.status(httpException.getStatusCode())
                    .body(ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
}
