/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.provider.impl;

import com.google.ads.googleads.v16.services.GoogleAdsRow;
import lombok.RequiredArgsConstructor;
import net.twobid.billing.api.CoreApi;
import net.twobid.googleads.dto.UserAccountInfoDto;
import net.twobid.googleads.provider.GoogleAdsDataProvider;
import net.twobid.googleads.query.Gaql;
import net.twobid.googleads.query.QueryBuilder;
import net.twobid.googleads.utils.NumberUtils;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.security.Principal;
import java.time.LocalDate;
import java.util.*;

@Component
@RequiredArgsConstructor
public class GoogleAdsAccountProvider extends GoogleAdsDataProvider.ProviderAware<GoogleAdsAccountProvider> {
    private final CoreApi coreApi;

    public double currencyRate(Principal principal, long customerId) throws Exception {
        return NumberUtils.roundSinglePlace(coreApi.currencyRate()
                .findByDate(LocalDate.now(), currencyCode(principal, customerId))
                .blockingSingle());
    }

    public String currencyCode(Principal principal, long customerId) throws Exception {
        QueryBuilder query = new QueryBuilder()
                .select(Gaql.Customer.currencyCode)
                .from(Gaql.Table.accountBudget)
                .where(Gaql.Customer.id + " = " + customerId)
                .limit(1);

        Iterator<GoogleAdsRow> it = query(principal, customerId, query);

        if (!it.hasNext())
            throw new NoSuchElementException("Account not found");

        return it.next().getCustomer().getCurrencyCode();
    }

    public GoogleAdsRow balance(Principal principal, long customerId) throws Exception {
        QueryBuilder query = new QueryBuilder()
                .select(Gaql.AccountBudget.adjustedSpendingLimitMicros,
                        Gaql.AccountBudget.amountServedMicros,
                        Gaql.Customer.currencyCode)
                .from(Gaql.Table.accountBudget)
                .where(Gaql.Customer.id + " = " + customerId)
                .limit(1);

        Iterator<GoogleAdsRow> it = query(principal, customerId, query);

        if (!it.hasNext())
            throw new NoSuchElementException("Account not found");

        return it.next();
    }

    public Optional<Long> findDefault(Principal principal) {
        return findAll(principal).getCustomerIds()
                .stream()
                .filter(UserAccountInfoDto.CustomerIdEntry::isMarkedDefault)
                .map(UserAccountInfoDto.CustomerIdEntry::getId)
                .findFirst();
    }

    public UserAccountInfoDto findAll(Principal principal) {
        return provider().getCustomData(principal, UserAccountInfoDto.class).orElseThrow();
    }

    public UserAccountInfoDto markDefault(Principal principal, long customerId) throws Exception {
        UserAccountInfoDto accountInfo = findAll(principal);

        for (var account : accountInfo.getCustomerIds())
            account.setMarkedDefault(Objects.equals(customerId, account.getId()));

        return provider().saveCustomData(principal, accountInfo);
    }

    private Long asCustomerId(String val) {
        try {
            return val == null ? null : Long.valueOf(val.substring(10));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void saveAccounts(URI state, List<String> accounts) throws Exception {
        List<UserAccountInfoDto.CustomerIdEntry> customerIds = new ArrayList<>();

        for (int i = 0; i < accounts.size(); i++) {
            customerIds.add(UserAccountInfoDto.CustomerIdEntry.builder()
                    .id(asCustomerId(accounts.get(i)))
                    .markedDefault(i == 0)
                    .build()
            );
        }

        provider().saveCustomData(state, UserAccountInfoDto.builder().customerIds(customerIds).build());
    }
}
