/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.shared.dao.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import jakarta.persistence.AttributeConverter;

/**
 * Converts JSON to String and vice versa.
 * Requires type field on target object such as:
 * &#064;JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, property="@class")
 */
@Slf4j
@Component
@jakarta.persistence.Converter(autoApply = false)
@RequiredArgsConstructor
public class JSONCustomConverter implements AttributeConverter<Object, String> {
    private final ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(Object o) {
        try {
            return o == null ? null : objectMapper.writerFor(o.getClass()).writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("Failed to convert data to JSON column: " + o, e);
        }
        return null;
    }

    @Override
    public Object convertToEntityAttribute(String json) {
        try {
            if(!StringUtils.isEmpty(json)) {
                JsonNode jsonNode = objectMapper.readTree(json);
                String type = jsonNode.get("@class").asText();
                return objectMapper.convertValue(jsonNode, Class.forName(type));
            }
        } catch (Exception e) {
            log.error("Failed to convert JSON from column: " + json, e);
        }
        return null;
    }
}
