/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.shared.model;

import lombok.Value;

import java.util.List;

@Value
public class PageTokenPage<T> {
    List<T> content;
    String nextPageToken;
    long totalElements;

    public <Output> PageTokenPage<Output> map(ValueMapper<T, Output> mapper) {
        return new PageTokenPage<>(
                content.stream().map(mapper::map).toList(),
                nextPageToken,
                totalElements
        );
    }

    public interface ValueMapper<Input, Output> {
        Output map(Input value);

        static <Input> ValueMapper<Input, Input> identity() {
            return value -> value;
        }
    }
}
