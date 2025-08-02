/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.security;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.twobid.billing.api.CoreApi;
import net.twobid.security.model.SecureStateAppInfoDto;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class SecureStateValidator implements HandlerInterceptor {
    @Value("${net.twobid.security.securestate.enabled:false}")
    private boolean enabled;
    @Value("${net.twobid.security.securestate.salt:xyz}")
    private String salt;
    @Value("${net.twobid.security.securestate.dispatchthreshold:2}")
    private int dispatchThreshold;
    private final CoreApi coreApi;

    private final Executor executor = Executors.newFixedThreadPool(4);
    private final Set<SecureStateAppInfoDto> appInfos = new LinkedHashSet<>();

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) throws Exception {
        try {
            String appInfo = request.getHeader("useful-info");

            if(!StringUtils.isEmpty(appInfo))
                logAppInfo(SecureStateAppInfoDto.from(Base64.getDecoder().decode(appInfo)));

            if (!enabled)
                return true;

            String nonce = request.getHeader("nonce");
            String token = request.getHeader("token");
            String checksum = request.getHeader("checksum");

            if (StringUtils.isEmpty(nonce) || StringUtils.isEmpty(token) || StringUtils.isEmpty(appInfo) || StringUtils.isEmpty(checksum)) {
                response.setHeader("X-Debug-info", "Nonce, token, appInfo or checksum is missing");
                response.sendError(HttpServletResponse.SC_PRECONDITION_FAILED);
                return false;
            }

            String computedChecksum = computeChecksum(request, salt, nonce, appInfo, token);

            boolean valid = computedChecksum.equals(checksum);

            if (!valid) {
                log.error("Invalid secure state: computed checksum: {}, checksum: {}", computedChecksum, checksum);
                response.setHeader("X-Debug-info", "Invalid secure state");
                response.sendError(HttpServletResponse.SC_PRECONDITION_FAILED);
                return false;
            }

            return true;
        } catch (Exception e) {
            log.error("Error validating secure state", e);

            response.setHeader("X-Debug-info", "Error validating secure state");
            response.sendError(HttpServletResponse.SC_PRECONDITION_FAILED);
            return false;
        }
    }

    private void logAppInfo(SecureStateAppInfoDto appInfo) {
        appInfos.add(appInfo);

        if(appInfos.size() >= dispatchThreshold) {
            executor.execute(() -> {
                coreApi.appSecureState().saveAppInfo(appInfos.stream().map(x -> {
                    var e = new net.twobid.core.api.model.SecureStateAppInfoDto();
                    e.setVersionName(x.getVersionName());
                    e.setVersionCode(x.getVersionCode());
                    e.setPackageName(x.getPackageName());
                    e.setFingerprints(x.getFingerprints());
                    return e;
                }).collect(Collectors.toList())).blockingSubscribe();
                appInfos.clear();
            });
        }
    }

    private String computeChecksum(HttpServletRequest request,
                                   String salt,
                                   String nonce,
                                   String appInfo,
                                   String appToken) throws Exception {
        StringBuilder sb = new StringBuilder()
                .append(request.getMethod());

        URI uri = URI.create(request.getRequestURI());

        String path = uri.getPath();

        if (!StringUtils.isEmpty(path)) {
            int slashIdx = path.indexOf('/', 1);

            if(slashIdx > 0)
                path = path.substring(slashIdx);

            sb.append(path);
        }

        String query = uri.getQuery();

        if (!StringUtils.isEmpty(query))
            sb.append(query);

        InputStream body = request.getInputStream();

        if (body != null) {
            String bodyString = IOUtils.toString(body, StandardCharsets.UTF_8);

            if (!StringUtils.isEmpty(bodyString))
                sb.append(bodyString);
        }

        sb.append(salt)
                .append(nonce)
                .append(appInfo)
                .append(appToken);

        return DigestUtils.sha256Hex(sb.toString());
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request,
                           @NonNull HttpServletResponse response,
                           @NonNull Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request,
                                @NonNull HttpServletResponse response,
                                @NonNull Object handler, Exception ex) throws Exception {

    }
}
