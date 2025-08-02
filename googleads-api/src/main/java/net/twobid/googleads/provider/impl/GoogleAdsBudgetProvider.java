/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.provider.impl;

import com.google.ads.googleads.lib.utils.FieldMasks;
import com.google.ads.googleads.v16.enums.BudgetDeliveryMethodEnum;
import com.google.ads.googleads.v16.resources.CampaignBudget;
import com.google.ads.googleads.v16.resources.CampaignBudgetName;
import com.google.ads.googleads.v16.services.CampaignBudgetOperation;
import com.google.ads.googleads.v16.services.CampaignBudgetServiceClient;
import lombok.RequiredArgsConstructor;
import net.twobid.billing.api.CoreApi;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GoogleAdsBudgetProvider extends GoogleAdsDataProvider.ProviderAware<GoogleAdsBudgetProvider> {
    private final CoreApi coreApi;

    public CampaignBudgetName save(Principal principal, long customerId, String budgetName, long budgetMicros)
            throws Exception {
        return save(principal, customerId, CampaignBudget.newBuilder()
                .setName(budgetName)
                .setAmountMicros(budgetMicros)
                .setDeliveryMethod(BudgetDeliveryMethodEnum.BudgetDeliveryMethod.STANDARD)
                .setExplicitlyShared(false)
                .build());
    }

    public CampaignBudgetName save(Principal principal, long customerId, CampaignBudget budget) throws Exception {
        try (CampaignBudgetServiceClient budgetClient = provider()
                .createClient(principal)
                .getLatestVersion()
                .createCampaignBudgetServiceClient()) {
            CampaignBudgetOperation operation;

            double m = provider().account().currencyRate(principal, customerId);

            budget = budget.toBuilder()
                    .setAmountMicros((long) (budget.getAmountMicros() * m))
                    .build();

            if (StringUtils.isEmpty(budget.getResourceName())) {
                operation = CampaignBudgetOperation.newBuilder()
                        .setCreate(budget)
                        .build();
            } else {
                operation = CampaignBudgetOperation.newBuilder()
                        .setUpdate(budget)
                        .setUpdateMask(FieldMasks.allSetFieldsOf(budget))
                        .build();
            }

            String resourceName = budgetClient.mutateCampaignBudgets(Long.toString(customerId), List.of(operation))
                    .getResults(0)
                    .getResourceName();

            return CampaignBudgetName.parse(resourceName);
        }
    }

}
