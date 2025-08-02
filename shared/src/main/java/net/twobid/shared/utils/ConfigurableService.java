/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.shared.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import net.twobid.shared.dao.ConfigurableServiceRepository;
import net.twobid.shared.dao.model.ConfigurableServiceEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;

@Slf4j
public abstract class ConfigurableService {
    private final ConfigurableServiceRepository repository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${spring.profiles.active:undefined}")
    private String activeProfile;
    private boolean isRunningInTests = false;

    public ConfigurableService(ConfigurableServiceRepository repository) {
        this.repository = repository;

        if(repository.findById(getId()).isEmpty()) {
            repository.saveAndFlush(new ConfigurableServiceEntity()
                    .setId(getId())
                    .setEnabled(false)
            );
        }
    }

    @PostConstruct
    void onInit() {
        if("test".equals(activeProfile)) {
            log.info("Disabling service {} running in test mode", getId());
            this.isRunningInTests = true;
        }
    }

    public abstract String getId();

    protected ConfigurableServiceEntity config() {
        ConfigurableServiceEntity result = repository.findById(getId()).orElseThrow();

        if(isRunningInTests)
            result.setEnabled(false);

        return result;
    }

    protected boolean isEnabled() {
        return config().isEnabled();
    }

    protected String getServiceUserId() {
        return config().getServiceUserId();
    }

    protected <T> Optional<T> getCustomData(Class<T> clazz) {
        return Optional.ofNullable(parseCustomData(getId(), config().getCustomData(), clazz));
    }

    protected <T> T saveCustomData(T data) throws Exception {
        String id = getId();
        ConfigurableServiceEntity entity = repository.findById(id).orElse(new ConfigurableServiceEntity().setId(id));
        try {
            entity.setCustomData(objectMapper.writeValueAsString(data));
            entity = repository.save(entity);
        } catch (JsonProcessingException e) {
            log.error("Failed to save ConfigurableService custom data for id {}", id, e);
        }

        return parseCustomData(id, entity.getCustomData(), (Class<T>) data.getClass());
    }

    private <T> T parseCustomData(String id, String customData, Class<T> clazz) {
        try {
            if (!StringUtils.isEmpty(customData))
                return objectMapper.readValue(customData, clazz);
        } catch (JsonProcessingException e) {
            log.error("Failed to parse ConfigurableService custom data for id {}", id, e);
        }

        return null;
    }
}
