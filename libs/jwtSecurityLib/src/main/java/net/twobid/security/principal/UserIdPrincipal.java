/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.security.principal;

import lombok.NonNull;
import lombok.ToString;

import java.security.Principal;

@ToString
public class UserIdPrincipal implements Principal {
    private final String userId;

    public UserIdPrincipal(@NonNull String userId) {
        this.userId = userId;
    }

    @Override
    public String getName() {
        return userId;
    }
}
