/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.google.oauth2;

import java.net.URI;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class URIUtils {
    public static String getQueryFirstParameterFromURI(URI uri, String param) {
        return Arrays.stream(uri.getQuery().split("&"))
                .filter(s -> s.startsWith(param))
                .map(s -> {
                    String[] split = s.split("=");
                    if (split.length != 2)
                        throw new IllegalArgumentException("Invalid query parameter: " + s);
                    return split[1];
                })
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No parameter " + param + " found in URI " + uri));
    }

}
