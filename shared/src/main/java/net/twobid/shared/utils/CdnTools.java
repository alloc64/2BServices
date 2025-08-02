/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.shared.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class CdnTools {
    @Value("${net.twobid.imageproxy.url:https://xyz.net/from-url/}")
    private String imageProxyUrl;

    public String cdnifyImageUrl(String url) {
        if (ObjectUtils.isEmpty(url))
            return url;

        return imageProxyUrl + url;
    }
}
