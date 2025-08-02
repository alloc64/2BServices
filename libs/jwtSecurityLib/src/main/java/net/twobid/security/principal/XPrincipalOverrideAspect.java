/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.security.principal;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import java.security.Principal;

@Aspect
@Component
public class XPrincipalOverrideAspect {
    @Autowired
    private HttpServletRequest request;

    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controller() {
    }

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restController() {
    }

    @Pointcut("args(java.security.Principal,..)")
    public void principalArgPointcut() {
    }

    @Around("(controller() || restController()) && principalArgPointcut()")
    public Object validate(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();

        if(args != null) {
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                if (arg instanceof Principal) {
                    String principal = request.getHeader("X-Principal");

                    if (!StringUtils.isEmpty(principal))
                        args[i] = new UserIdPrincipal(principal);
                }
            }
        }

        return point.proceed(args);
    }
}
