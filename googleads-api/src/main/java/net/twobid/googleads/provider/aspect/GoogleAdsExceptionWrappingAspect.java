/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.provider.aspect;

import com.google.ads.googleads.v16.errors.GoogleAdsException;
import com.google.ads.googleads.v16.errors.GoogleAdsFailure;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@Aspect
public class GoogleAdsExceptionWrappingAspect {
    @Pointcut("within(net.twobid.googleads.provider.impl.*) && execution(* *(..))")
    public void catchAllImpl() {}

    @Around("catchAllImpl()")
    public Object rethrowExistingException(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        try {
            return thisJoinPoint.proceed();
        } catch (GoogleAdsException e) {
            StringBuilder errors = new StringBuilder();

            GoogleAdsFailure failure = e.getGoogleAdsFailure();

            if(failure != null)
                for(int i = 0; i < failure.getErrorsCount(); i++)
                    errors.append(failure.getErrors(i).getMessage()).append("\n");

            throw new ResponseStatusException(400, errors.toString(), e);
        }
    }
}
