/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.query;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountryCriterion {
    private static final Map<Long, String> countryCriteriaToCountryCode = new LinkedHashMap<>();

    static {
        try {
            InputStream is = new ClassPathResource("criterion.csv").getInputStream();
            for(String token : IOUtils.toString(is, StandardCharsets.UTF_8).split("\\|")) {
                String[] s = token.split(",");
                long criteria = Long.parseLong(s[0]);
                String countryCode = s[1];

                countryCriteriaToCountryCode.put(criteria, countryCode);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String resolve(Long id) {
        return countryCriteriaToCountryCode.get(id);
    }

    public static void initialize() {
        // to call static constructor ahead of time
    }
}
