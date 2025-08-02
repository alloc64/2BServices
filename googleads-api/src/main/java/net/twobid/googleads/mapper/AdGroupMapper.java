/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.mapper;

import com.google.ads.googleads.v16.enums.AdGroupStatusEnum;
import com.google.ads.googleads.v16.resources.AdGroup;
import com.google.ads.googleads.v16.services.GoogleAdsRow;
import net.twobid.googleads.dto.AdGroupDto;
import net.twobid.googleads.dto.AdGroupNameDto;
import net.twobid.googleads.dto.AdGroupStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class AdGroupMapper {
    public abstract AdGroupStatus resolve(AdGroupStatusEnum.AdGroupStatus status);

    @Mappings({
            @Mapping(target = "id", source = "adGroup.id"),
            @Mapping(target = "customerId", source = "customer.id"),
            @Mapping(target = "campaignId", source = "campaign.id"),
            @Mapping(target = "name", source = "adGroup.name"),
            @Mapping(target = "status", source = "adGroup.status")
    })
    public abstract AdGroupDto resolve(GoogleAdsRow row);

    public AdGroup resolve(AdGroupDto input) {
        AdGroup.Builder adGroup = AdGroup.newBuilder()
                .setName(input.getName())
                .setStatus(AdGroupStatusEnum.AdGroupStatus.valueOf(input.getStatus().name()));

        if(input.getId() != null)
            adGroup.setId(input.getId());

        return adGroup.build();
    }

    @Mapping(target = "name", source = "adGroup.name")
    public abstract AdGroupNameDto resolveName(GoogleAdsRow googleAdsRow);
}

