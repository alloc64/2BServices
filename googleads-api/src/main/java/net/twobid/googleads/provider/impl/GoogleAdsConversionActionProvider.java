/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.provider.impl;

import com.google.ads.googleads.v16.enums.ConversionActionTypeEnum;
import com.google.ads.googleads.v16.resources.ConversionAction;
import com.google.ads.googleads.v16.services.GoogleAdsRow;
import lombok.RequiredArgsConstructor;
import net.twobid.googleads.dao.CustomConversionActionRepository;
import net.twobid.googleads.dao.model.CustomConversionActionEntity;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import net.twobid.googleads.query.Gaql;
import net.twobid.googleads.query.QueryBuilder;
import net.twobid.shared.model.PageTokenPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GoogleAdsConversionActionProvider extends GoogleAdsDataProvider.ProviderAware<GoogleAdsConversionActionProvider> {
    private final QueryBuilder conversionActionQuery = new QueryBuilder()
            .select(Gaql.ConversionAction.appId,
                    Gaql.ConversionAction.attributionModelSettingsAttributionModel,
                    Gaql.ConversionAction.attributionModelSettingsDataDrivenModelStatus,
                    Gaql.ConversionAction.category,
                    Gaql.ConversionAction.clickThroughLookbackWindowDays,
                    Gaql.ConversionAction.countingType,
                    Gaql.ConversionAction.firebaseSettingsEventName,
                    Gaql.ConversionAction.firebaseSettingsProjectId,
                    Gaql.ConversionAction.firebaseSettingsPropertyId,
                    Gaql.ConversionAction.firebaseSettingsPropertyName,
                    Gaql.ConversionAction.id,
                    Gaql.ConversionAction.includeInConversionsMetric,
                    Gaql.ConversionAction.mobileAppVendor,
                    Gaql.ConversionAction.name,
                    Gaql.ConversionAction.origin,
                    Gaql.ConversionAction.ownerCustomer,
                    Gaql.ConversionAction.phoneCallDurationSeconds,
                    Gaql.ConversionAction.primaryForGoal,
                    Gaql.ConversionAction.resourceName,
                    Gaql.ConversionAction.status,
                    Gaql.ConversionAction.tagSnippets,
                    Gaql.ConversionAction.thirdPartyAppAnalyticsSettingsEventName,
                    Gaql.ConversionAction.thirdPartyAppAnalyticsSettingsProviderName,
                    Gaql.ConversionAction.type,
                    Gaql.ConversionAction.valueSettingsAlwaysUseDefaultValue,
                    Gaql.ConversionAction.valueSettingsDefaultCurrencyCode,
                    Gaql.ConversionAction.valueSettingsDefaultValue,
                    Gaql.ConversionAction.viewThroughLookbackWindowDays)
            .from(Gaql.Table.conversionAction);

    private final CustomConversionActionRepository customConversionActionRepository;

    public <Output> List<Output> findAll(Principal principal,
                                         long customerId,
                                         String appId,
                                         PageTokenPage.ValueMapper<ConversionAction, Output> mapper) throws Exception {
        QueryBuilder query = conversionActionQuery.clone()
                .where(Gaql.ConversionAction.appId + " = ':appId' AND " + Gaql.ConversionAction.status + " = 'ENABLED'")
                .withBindVariableValue("appId", appId);

        Set<ConversionAction> unmapped = new LinkedHashSet<>(queryList(principal, customerId, query)
                .stream()
                .map(GoogleAdsRow::getConversionAction)
                .toList()) {
        };

        unmapped.addAll(
                findAllCustomConversionActions(principal, customerId)
                        .stream()
                        .filter(conversionAction -> conversionAction.getAppId().equals(appId))
                        .toList()
        );

        return unmapped.stream().map(mapper::map).toList();
    }

    public ConversionAction findById(Principal principal, long customerId, long conversionActionId) throws Exception {
        List<ConversionAction> list = findById(principal, customerId, List.of(conversionActionId));

        if (!list.isEmpty())
            return list.get(0);

        throw new NoSuchElementException("Conversion action %s not found".formatted(conversionActionId));
    }

    public List<ConversionAction> findById(Principal principal, long customerId, List<Long> conversionActionIds)
            throws Exception {
        QueryBuilder query = conversionActionQuery.clone()
                .where(Gaql.ConversionAction.id + " IN(:id)")
                .withBindVariableValue("id", StringUtils.join(conversionActionIds, ","));

        List<ConversionAction> result = queryList(principal, customerId, query)
                .stream()
                .map(GoogleAdsRow::getConversionAction)
                .toList();

        Map<Long, ConversionAction> conversionActionMap = new LinkedHashMap<>(
                result.stream().collect(Collectors.toMap(ConversionAction::getId, Function.identity()))
        );

        findAllCustomConversionActions(principal, customerId)
                .stream()
                .filter(conversionAction -> conversionActionIds.contains(conversionAction.getId()))
                .forEach(conversionAction -> conversionActionMap.putIfAbsent(conversionAction.getId(), conversionAction));

        for (Long id : conversionActionIds) {
            if (!conversionActionMap.containsKey(id)) {
                conversionActionMap.put(id, ConversionAction.newBuilder()
                        .setId(id)
                        .setName("Unknown Conversion action %d".formatted(id))
                        .setResourceName("customers/%d/conversionActions/%d".formatted(customerId, id))
                        .build());
            }
        }

        return conversionActionMap.values().stream().toList();
    }

    public ConversionAction save(Principal principal, long customerId, ConversionAction conversionAction) throws Exception {
        CustomConversionActionEntity e = customConversionActionRepository
                .findByUserIdAndCustomerIdAndId(principal.getName(), customerId, conversionAction.getId())
                .orElseGet(CustomConversionActionEntity::new);

        e.setId(conversionAction.getId());
        e.setBundleId(conversionAction.getAppId());
        e.setCustomerId(customerId);
        e.setUserId(principal.getName());
        e.setName(conversionAction.getName());
        e.setType(conversionAction.getType().name());

        return mapToConversionAction(
                customConversionActionRepository.save(e)
        );
    }

    public void deleteCustomConversionAction(Principal principal, long customerId, long conversionActionId) {
        customConversionActionRepository.deleteByUserIdAndCustomerIdAndId(
                principal.getName(), customerId, conversionActionId);
    }

    private List<ConversionAction> findAllCustomConversionActions(Principal principal, long customerId) {
        return customConversionActionRepository
                .findAllByUserIdAndCustomerId(principal.getName(), customerId)
                .stream()
                .map(this::mapToConversionAction)
                .toList();
    }

    private ConversionAction mapToConversionAction(CustomConversionActionEntity entity) {
        return ConversionAction.newBuilder()
                .setId(entity.getId())
                .setName(entity.getName())
                .setType(ConversionActionTypeEnum.ConversionActionType.valueOf(entity.getType()))
                .setAppId(entity.getBundleId())
                .setResourceName("customers/%d/conversionActions/%d".formatted(entity.getCustomerId(), entity.getId()))
                .build();
    }
}
