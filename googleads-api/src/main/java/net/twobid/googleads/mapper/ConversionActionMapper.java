/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.mapper;

import com.google.ads.googleads.v16.enums.ConversionActionTypeEnum;
import com.google.ads.googleads.v16.resources.ConversionAction;
import com.google.ads.googleads.v16.resources.ConversionActionName;
import net.twobid.googleads.dto.ConversionActionDto;
import net.twobid.googleads.dto.ConversionActionType;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public abstract class ConversionActionMapper {
    public ConversionAction resolve(ConversionActionDto conversionAction) {
        return ConversionAction.newBuilder()
                .setId(conversionAction.getId())
                .setName(conversionAction.getName())
                .setType(ConversionActionTypeEnum.ConversionActionType.valueOf(conversionAction.getType().name()))
                .setAppId(conversionAction.getBundleId())
                .build();
    }

    public ConversionActionDto resolve(ConversionAction conversionAction) {
        ConversionActionName conversionActionName = ConversionActionName.parse(conversionAction.getResourceName());

        return new ConversionActionDto()
                .setName(conversionAction.getName())
                .setId(Long.parseLong(conversionActionName.getConversionActionId()))
                .setBundleId(conversionAction.getAppId())
                .setCustomerId(Long.parseLong(conversionActionName.getCustomerId()))
                .setType(ConversionActionType.fromString(conversionAction.getType().name()));
    }

    public ConversionActionName resolveConversionActionName(ConversionActionDto conversionAction) {
        return ConversionActionName.of(String.valueOf(conversionAction.getCustomerId()), String.valueOf(conversionAction.getId()));
    }

    public abstract List<ConversionActionName> resolveConversionActionList(List<ConversionActionDto> conversionAction);

    public abstract List<ConversionActionDto> resolve(List<ConversionAction> conversionActions);
}

