/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.geotargetsgen;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class GoogleAdsGeotargetsGen {

    public static void main(String[] args) throws IOException {
        File tempFolder = new File("./tmp/gads-geotarget-gen");
        File geotargetsCsvFile = new File(tempFolder, "geotargets-2024-03-20.csv");
        File countryCodesCsvFile = new File(tempFolder, "country-codes.csv");

        CsvMapper csvMapper = new CsvMapper();

        Map<String, List<String>> countryLanguagesMap = new HashMap<>();
        try (MappingIterator<Country> it = csvMapper.readerFor(Country.class)
                .with(countiesCsvSchema)
                .readValues(countryCodesCsvFile)) {
            for (Country country : it.readAll()) {
                String isoCode = country.getIso3166Alpha2();
                String languages =country.getLanguages();

                if(languages == null || languages.isEmpty())
                    continue;

                countryLanguagesMap.put(isoCode, Arrays.asList(languages.split(",")));
            }
        }

        List<GeoTarget> geoTargets;
        try (MappingIterator<GeoTarget> mappingIterator = csvMapper.readerFor(GeoTarget.class)
                .with(geoTargetsCsvSchema)
                .readValues(geotargetsCsvFile)) {

            geoTargets = mappingIterator.readAll();
        }

        List<GeoTargetDto> filteredGeoTargets = geoTargets.stream()
                .filter(geoTarget -> "Country".equals(geoTarget.getTargetType()))
                .map(g -> new GeoTargetDto(g)
                        .setLanguages(countryLanguagesMap.getOrDefault(g.getCountryCode(), new ArrayList<>())))
                .collect(Collectors.toList());

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredGeoTargets);

        try (FileOutputStream outputStream = new FileOutputStream(new File(tempFolder, "output.json"))) {
            outputStream.write(jsonOutput.getBytes());
        }

    }

    static CsvSchema geoTargetsCsvSchema = CsvSchema.builder()
            .addColumn("criteriaId", CsvSchema.ColumnType.NUMBER)
            .addColumn("name", CsvSchema.ColumnType.STRING)
            .addColumn("canonicalName", CsvSchema.ColumnType.STRING)
            .addColumn("parentId", CsvSchema.ColumnType.NUMBER)
            .addColumn("countryCode", CsvSchema.ColumnType.STRING)
            .addColumn("targetType", CsvSchema.ColumnType.STRING)
            .addColumn("status", CsvSchema.ColumnType.STRING)
            .build().withHeader();

    static CsvSchema countiesCsvSchema = CsvSchema.builder()
            .addColumn("FIFA")
            .addColumn("Dial")
            .addColumn("ISO3166-1-Alpha-3")
            .addColumn("MARC")
            .addColumn("is_independent")
            .addColumn("ISO3166-1-numeric")
            .addColumn("GAUL")
            .addColumn("FIPS")
            .addColumn("WMO")
            .addColumn("ISO3166-1-Alpha-2")
            .addColumn("ITU")
            .addColumn("IOC")
            .addColumn("DS")
            .addColumn("UNTERM Spanish Formal")
            .addColumn("Global Code")
            .addColumn("Intermediate Region Code")
            .addColumn("official_name_fr")
            .addColumn("UNTERM French Short")
            .addColumn("ISO4217-currency_name")
            .addColumn("Developed / Developing Countries")
            .addColumn("UNTERM Russian Formal")
            .addColumn("UNTERM English Short")
            .addColumn("ISO4217-currency_alphabetic_code")
            .addColumn("Small Island Developing States (SIDS)")
            .addColumn("UNTERM Spanish Short")
            .addColumn("ISO4217-currency_numeric_code")
            .addColumn("UNTERM Chinese Formal")
            .addColumn("UNTERM French Formal")
            .addColumn("UNTERM Russian Short")
            .addColumn("M49")
            .addColumn("Sub-region Code")
            .addColumn("Region Code")
            .addColumn("official_name_ar")
            .addColumn("ISO4217-currency_minor_unit")
            .addColumn("UNTERM Arabic Formal")
            .addColumn("UNTERM Chinese Short")
            .addColumn("Land Locked Developing Countries (LLDC)")
            .addColumn("Intermediate Region Name")
            .addColumn("official_name_es")
            .addColumn("UNTERM English Formal")
            .addColumn("official_name_cn")
            .addColumn("official_name_en")
            .addColumn("ISO4217-currency_country_name")
            .addColumn("Least Developed Countries (LDC)")
            .addColumn("Region Name")
            .addColumn("UNTERM Arabic Short")
            .addColumn("Sub-region Name")
            .addColumn("official_name_ru")
            .addColumn("Global Name")
            .addColumn("Capital")
            .addColumn("Continent")
            .addColumn("TLD")
            .addColumn("Languages")
            .addColumn("Geoname ID")
            .addColumn("CLDR display name")
            .addColumn("EDGAR")
            .build().withHeader();

}
