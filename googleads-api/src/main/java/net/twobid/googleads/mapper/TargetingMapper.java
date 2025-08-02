/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.mapper;

import com.google.ads.googleads.v16.common.LocationInfo;
import com.google.ads.googleads.v16.resources.GeoTargetConstant;
import com.google.ads.googleads.v16.services.SuggestGeoTargetConstantsRequest;
import net.twobid.googleads.dto.GeoTargetConstantDto;
import net.twobid.googleads.dto.LocationTargetingDto;
import net.twobid.googleads.dto.SuggestGeoTargetConstantsRequestDto;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public abstract class TargetingMapper {
    public List<LocationInfo> resolve(LocationTargetingDto targeting) {
        return targeting.getGeoTargetConstants().stream()
                .map(g -> LocationInfo.newBuilder()
                        .setGeoTargetConstant(g.getResourceName())
                        .build())
                .toList();
    }

    public SuggestGeoTargetConstantsRequest resolve(SuggestGeoTargetConstantsRequestDto request) {
        SuggestGeoTargetConstantsRequest.Builder b = SuggestGeoTargetConstantsRequest.newBuilder()
                .setLocale("en")
                .setLocationNames(SuggestGeoTargetConstantsRequest.LocationNames.newBuilder()
                        .addAllNames(request.getCountryCodes())
                        .build()
                );

        if(!StringUtils.isEmpty(request.getRestrictToCountryCode()))
            b.setCountryCode(request.getRestrictToCountryCode());

        return b.build();
    }

    @Mappings({
            @Mapping(target = "resourceName", source = "resourceName"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "countryCode", source = "countryCode"),
            @Mapping(target = "canonicalName", source = "canonicalName"),
    })
    public abstract GeoTargetConstantDto resolve(GeoTargetConstant constant);

    public abstract List<GeoTargetConstantDto> resolve(List<GeoTargetConstant> list);
}
