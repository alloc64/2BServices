/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.mapper;

import com.google.ads.googleads.v16.resources.AccountBudget;
import com.google.ads.googleads.v16.services.GoogleAdsRow;
import net.twobid.googleads.dto.AccountInfoDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class AccountMapper {
    public AccountInfoDto resolve(GoogleAdsRow row) {
        AccountBudget budget = row.getAccountBudget();

        return new AccountInfoDto()
                .setBalanceMicros(budget.getAdjustedSpendingLimitMicros() - budget.getAmountServedMicros())
                .setCurrencyCode(row.getCustomer().getCurrencyCode());
    }
}
