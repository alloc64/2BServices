/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.shared.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PageTokenPageable {
    private int pageSize;
    private String pageToken;

    public PageTokenPageable(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageTokenPageable(int pageSize, String pageToken) {
        this.pageSize = pageSize;
        this.pageToken = pageToken;
    }
}

