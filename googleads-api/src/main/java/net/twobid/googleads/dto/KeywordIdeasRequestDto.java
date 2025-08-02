/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dto;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
public class KeywordIdeasRequestDto {
    @NotEmpty
    private String url;
    private List<String> countryCodes = new ArrayList<>();
}
