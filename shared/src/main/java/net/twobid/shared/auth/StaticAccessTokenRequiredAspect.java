/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.shared.auth;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class StaticAccessTokenRequiredAspect {
    private final HttpServletRequest request;

    public StaticAccessTokenRequiredAspect(HttpServletRequest request) {
        this.request = request;
    }

    @Pointcut("@annotation(net.twobid.shared.auth.StaticAccessTokenRequired)")
    public void validateAccessToken() {

    }

    @Before("validateAccessToken()")
    public void validateAccessTokenCall(JoinPoint call) throws AuthenticationException {
        String token = asToken(request.getHeader("Authorization"));

        MethodSignature signature = (MethodSignature) call.getSignature();
        StaticAccessTokenRequired val = signature.getMethod().getAnnotation(StaticAccessTokenRequired.class);

        if (!val.value().equals(token))
            throw new AuthenticationException("Authentication failed");
    }

    private String asToken(String bearer) {
        if (bearer != null) {
            String[] splits = bearer.split(" ");

            if (splits.length == 2)
                return splits[1];
        }

        return null;
    }
}
