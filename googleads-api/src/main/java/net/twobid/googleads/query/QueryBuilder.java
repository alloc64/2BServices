/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.query;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QueryBuilder {
    protected static final String SELECT = "SELECT";
    protected static final String FROM = "FROM";
    protected static final String WHERE = "WHERE";
    protected static final String LIMIT = "LIMIT";
    protected static final String OFFSET = "OFFSET";
    protected static final String ORDER_BY = "ORDER BY";

    protected List<String> select;
    protected List<String> from;
    protected List<String> where;
    protected Integer limit;

    @Getter
    protected Integer offset;
    protected List<String> orderBy;

    protected Map<String, Object> values;

    public QueryBuilder() {
        this(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null, null, new ArrayList<>(), new LinkedHashMap<>());
    }

    public QueryBuilder(QueryBuilder q) {
        this(new ArrayList<>(q.select), new ArrayList<>(q.from), new ArrayList<>(q.where), q.limit, q.offset,
                new ArrayList<>(q.orderBy), new LinkedHashMap<>(q.values));
    }

    public QueryBuilder(List<String> select, List<String> from, List<String> where, Integer limit, Integer offset, List<String> orderBy, Map<String, Object> values) {
        this.select = select;
        this.from = from;
        this.where = where;
        this.limit = limit;
        this.offset = offset;
        this.orderBy = orderBy;
        this.values = values;
    }

    public QueryBuilder clone() {
        return new QueryBuilder(this);
    }

    /**
     * Sets the statement SELECT clause in the form of "a,b" or "*". Only necessary for statements
     * being sent to the {@code PublisherQueryLanguageService}. The "SELECT " keyword will be ignored.
     *
     * @param columns the statement select clause without "SELECT"
     * @return a reference to this object
     */
    @CanIgnoreReturnValue
    public QueryBuilder select(String... columns) {
        Preconditions.checkNotNull(columns, "SELECT clause cannot be null");
        this.select.addAll(List.of(columns));
        return this;
    }

    public QueryBuilder clearSelect() {
        this.select.clear();
        return this;
    }

    /**
     * Sets the statement FROM clause in the form of "table". Only necessary for statements being sent
     * to the {@code PublisherQueryLanguageService}. The "FROM " keyword will be ignored.
     *
     * @param table the statement from clause without "FROM"
     * @return a reference to this object
     */
    @CanIgnoreReturnValue
    public QueryBuilder from(String... table) {
        Preconditions.checkNotNull(table, "FROM clause cannot be null");
        this.from.addAll(List.of(table));
        return this;
    }

    public QueryBuilder clearFrom() {
        this.from.clear();
        return this;
    }

    /**
     * Sets the statement WHERE clause in the form of<br>
     * <br>
     * <code>"WHERE &lt;condition&gt; {[AND | OR] &lt;condition&gt; ...}"</code> <br>
     * <br>
     * e.g. "a = b OR b = c". The "WHERE " keyword will be ignored.
     *
     * @param conditions the statement query without "WHERE"
     * @return a reference to this object
     */
    @CanIgnoreReturnValue
    public QueryBuilder where(String... conditions) {
        Preconditions.checkNotNull(conditions, "WHERE clause cannot be null");
        this.where.addAll(List.of(conditions));
        return this;
    }

    public QueryBuilder clearWhere() {
        this.where.clear();
        return this;
    }

    /**
     * Sets the statement LIMIT clause in the form of<br>
     * <br>
     * <code>"LIMIT &lt;count&gt;"</code> <br>
     * <br>
     * e.g. 1000.
     *
     * @param count the statement limit
     * @return a reference to this object
     */
    @CanIgnoreReturnValue
    public QueryBuilder limit(Integer count) {
        this.limit = count;
        return this;
    }

    /**
     * Sets the statement OFFSET clause in the form of<br>
     * <br>
     * <code>"OFFSET &lt;count&gt;"</code> <br>
     * <br>
     * e.g. 200.
     *
     * @param count the statement offset
     * @return a reference to this object
     */
    @CanIgnoreReturnValue
    public QueryBuilder offset(Integer count) {
        this.offset = count;
        return this;
    }

    @CanIgnoreReturnValue
    public QueryBuilder clearimitAndOffset() {
        offset = null;
        limit = null;
        return this;
    }

    /**
     * Sets the statement ORDER BY clause in the form of<br>
     * <br>
     * <code>"ORDER BY &lt;property&gt; [ASC | DESC]"</code> <br>
     * <br>
     * e.g. "type ASC, lastModifiedDateTime DESC".
     *
     * @param orderBy the statement order by without "ORDER BY"
     * @return a reference to this object
     */
    @CanIgnoreReturnValue
    public QueryBuilder orderBy(String... orderBy) {
        Preconditions.checkNotNull(orderBy, "ORDER BY clause cannot be null");
        this.orderBy.addAll(List.of(orderBy));
        return this;
    }

    public QueryBuilder clearOrderBy() {
        this.orderBy.clear();
        return this;
    }

    /**
     * Adds a value to the statement in the form of a {@code Value}.
     *
     * @param key   the value key
     * @param value the value
     * @return a reference to this object
     */
    @CanIgnoreReturnValue
    public QueryBuilder withBindVariableValue(String key, Object value) {
        values.put(key, value);
        return this;
    }

    /**
     * Adds all key value mappings.
     *
     * @param values the mappings of key to value of type
     * @return a reference to this object
     */
    @CanIgnoreReturnValue
    public QueryBuilder withBindVariableValues(Map<String, Object> values) {
        this.values.putAll(values);
        return this;
    }

    public QueryBuilder clearBindVariableValues() {
        this.values.clear();
        return this;
    }

    public String buildQuery() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!select.isEmpty()) {
            stringBuilder.append(SELECT).append(" ").append(StringUtils.join(select, ", ")).append(" ");
        }
        if (!from.isEmpty()) {
            stringBuilder.append(FROM).append(" ").append(StringUtils.join(from, ", ")).append(" ");
        }
        if (!where.isEmpty()) {
            stringBuilder.append(WHERE).append(" ").append(StringUtils.join(where, " ")).append(" ");
        }
        if (!orderBy.isEmpty()) {
            stringBuilder.append(ORDER_BY).append(" ").append(StringUtils.join(orderBy, ", ")).append(" ");
        }
        if (limit != null) {
            stringBuilder.append(LIMIT).append(" ").append(limit).append(" ");
        }
        if (offset != null) {
            stringBuilder.append(OFFSET).append(" ").append(offset).append(" ");
        }

        String query = stringBuilder.toString().trim();

        for(Map.Entry<String, Object> entry : values.entrySet()) {
            String key = ":" + entry.getKey();
            Object value = entry.getValue();

            if(query.contains(key))
                query = query.replace(key, value.toString());
        }
        return query;
    }

    @Override
    public String toString() {
        return buildQuery();
    }
}
