/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.google.oauth2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.TokenStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class TwobidTokenStore implements TokenStore {
    private final TokenStoreRepository repository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String load(String id) throws IOException {
        return repository.findById(id)
                .orElseThrow()
                .getTokens();
    }

    @Override
    public void store(String id, String tokens) throws IOException {
        TokenStoreEntity entity = repository.findById(id).orElseGet(TokenStoreEntity::new);
        entity.setUserId(id);
        entity.setTokens(tokens);
        repository.save(entity);
    }

    @Override
    public void delete(String id) throws IOException {
        repository.deleteById(id);
    }

    protected <T> Optional<T> getCustomData(String id, Class<T> clazz) {
        String customData = repository.findById(id)
                .orElseThrow()
                .getCustomData();

        return Optional.ofNullable(parseCustomData(id, customData, clazz));
    }

    protected <T> T saveCustomData(String id, T data) throws Exception {
        TokenStoreEntity entity = repository.findById(id).orElse(new TokenStoreEntity().setUserId(id));
        try {
            entity.setCustomData(objectMapper.writeValueAsString(data));
            entity = repository.save(entity);
        } catch (JsonProcessingException e) {
            log.error("Failed to save TokenStore custom data for id {}", id, e);
        }

        return parseCustomData(id, entity.getCustomData(), (Class<T>) data.getClass());
    }

    private <T> T parseCustomData(String id, String customData, Class<T> clazz) {
        try {
            if (!StringUtils.isEmpty(customData))
                return objectMapper.readValue(customData, clazz);
        } catch (JsonProcessingException e) {
            log.error("Failed to parse TokenStore custom data for id {}", id, e);
        }

        return null;
    }
}
