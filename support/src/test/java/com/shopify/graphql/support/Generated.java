// Generated from graphql_java_gen gem

package com.shopify.graphql.support;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shopify.graphql.support.AbstractResponse;
import com.shopify.graphql.support.Arguments;
import com.shopify.graphql.support.Error;
import com.shopify.graphql.support.Query;
import com.shopify.graphql.support.SchemaViolationError;
import com.shopify.graphql.support.TopLevelResponse;

import com.shopify.graphql.support.ID;

import java.time.LocalDateTime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Generated {
    public static QueryRootQuery query(QueryRootQueryDefinition queryDef) {
        StringBuilder queryString = new StringBuilder("{");
        QueryRootQuery query = new QueryRootQuery(queryString);
        queryDef.define(query);
        queryString.append('}');
        return query;
    }

    public static class QueryResponse {
        private TopLevelResponse response;
        private QueryRoot data;

        public QueryResponse(TopLevelResponse response) throws SchemaViolationError {
            this.response = response;
            this.data = response.getData() != null ? new QueryRoot(response.getData()) : null;
        }

        public QueryRoot getData() {
            return data;
        }

        public List<Error> getErrors() {
            return response.getErrors();
        }

        public String toJson() {
            return new Gson().toJson(response);
        }

        public String prettyPrintJson() {
            final Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(response);
        }

        public static QueryResponse fromJson(String json) throws SchemaViolationError {
            final TopLevelResponse response = new Gson().fromJson(json, TopLevelResponse.class);
            return new QueryResponse(response);
        }
    }

    public static MutationQuery mutation(MutationQueryDefinition queryDef) {
        StringBuilder queryString = new StringBuilder("mutation{");
        MutationQuery query = new MutationQuery(queryString);
        queryDef.define(query);
        queryString.append('}');
        return query;
    }

    public static class MutationResponse {
        private TopLevelResponse response;
        private Mutation data;

        public MutationResponse(TopLevelResponse response) throws SchemaViolationError {
            this.response = response;
            this.data = response.getData() != null ? new Mutation(response.getData()) : null;
        }

        public Mutation getData() {
            return data;
        }

        public List<Error> getErrors() {
            return response.getErrors();
        }

        public String toJson() {
            return new Gson().toJson(response);
        }

        public String prettyPrintJson() {
            final Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(response);
        }

        public static MutationResponse fromJson(String json) throws SchemaViolationError {
            final TopLevelResponse response = new Gson().fromJson(json, TopLevelResponse.class);
            return new MutationResponse(response);
        }
    }

    public interface EntryQueryDefinition {
        void define(EntryQuery _queryBuilder);
    }

    public static class EntryQuery extends Query<EntryQuery> {
        EntryQuery(StringBuilder _queryBuilder) {
            super(_queryBuilder);

            startField("__typename");
        }

        public EntryQuery key() {
            startField("key");

            return this;
        }

        public EntryQuery ttl() {
            startField("ttl");

            return this;
        }

        public EntryQuery onIntegerEntry(IntegerEntryQueryDefinition queryDef) {
            startInlineFragment("IntegerEntry");
            queryDef.define(new IntegerEntryQuery(_queryBuilder));
            _queryBuilder.append('}');
            return this;
        }

        public EntryQuery onStringEntry(StringEntryQueryDefinition queryDef) {
            startInlineFragment("StringEntry");
            queryDef.define(new StringEntryQuery(_queryBuilder));
            _queryBuilder.append('}');
            return this;
        }
    }

    public interface Entry {
        String getGraphQlTypeName();

        String getKey();

        LocalDateTime getTtl();
    }

    public static class UnknownEntry extends AbstractResponse<UnknownEntry> implements Entry {
        public UnknownEntry() {
        }

        public UnknownEntry(JsonObject fields) throws SchemaViolationError {
            for (Map.Entry<String, JsonElement> field : fields.entrySet()) {
                String key = field.getKey();
                String fieldName = getFieldName(key);
                switch (fieldName) {
                    case "key": {
                        responseData.put(key, jsonAsString(field.getValue(), key));

                        break;
                    }

                    case "ttl": {
                        LocalDateTime optional1 = null;
                        if (!field.getValue().isJsonNull()) {
                            optional1 = LocalDateTime.parse(jsonAsString(field.getValue(), key));
                        }

                        responseData.put(key, optional1);

                        break;
                    }

                    case "__typename": {
                        responseData.put(key, jsonAsString(field.getValue(), key));
                        break;
                    }
                    default: {
                        throw new SchemaViolationError(this, key, field.getValue());
                    }
                }
            }
        }

        public static Entry create(JsonObject fields) throws SchemaViolationError {
            String typeName = fields.getAsJsonPrimitive("__typename").getAsString();
            switch (typeName) {
                case "IntegerEntry": {
                    return new IntegerEntry(fields);
                }

                case "StringEntry": {
                    return new StringEntry(fields);
                }

                default: {
                    return new UnknownEntry(fields);
                }
            }
        }

        public String getGraphQlTypeName() {
            return (String) get("__typename");
        }

        public String getKey() {
            return (String) get("key");
        }

        public UnknownEntry setKey(String arg) {
            optimisticData.put("key", arg);
            return this;
        }

        public LocalDateTime getTtl() {
            return (LocalDateTime) get("ttl");
        }

        public UnknownEntry setTtl(LocalDateTime arg) {
            optimisticData.put("ttl", arg);
            return this;
        }

        public boolean unwrapsToObject(String key) {
            switch (getFieldName(key)) {
                case "key": return false;

                case "ttl": return false;

                default: return false;
            }
        }
    }

    public interface IntegerEntryQueryDefinition {
        void define(IntegerEntryQuery _queryBuilder);
    }

    public static class IntegerEntryQuery extends Query<IntegerEntryQuery> {
        IntegerEntryQuery(StringBuilder _queryBuilder) {
            super(_queryBuilder);
        }

        public IntegerEntryQuery key() {
            startField("key");

            return this;
        }

        public IntegerEntryQuery ttl() {
            startField("ttl");

            return this;
        }

        public IntegerEntryQuery value() {
            startField("value");

            return this;
        }
    }

    public static class IntegerEntry extends AbstractResponse<IntegerEntry> implements Entry {
        public IntegerEntry() {
        }

        public IntegerEntry(JsonObject fields) throws SchemaViolationError {
            for (Map.Entry<String, JsonElement> field : fields.entrySet()) {
                String key = field.getKey();
                String fieldName = getFieldName(key);
                switch (fieldName) {
                    case "key": {
                        responseData.put(key, jsonAsString(field.getValue(), key));

                        break;
                    }

                    case "ttl": {
                        LocalDateTime optional1 = null;
                        if (!field.getValue().isJsonNull()) {
                            optional1 = LocalDateTime.parse(jsonAsString(field.getValue(), key));
                        }

                        responseData.put(key, optional1);

                        break;
                    }

                    case "value": {
                        responseData.put(key, jsonAsInteger(field.getValue(), key));

                        break;
                    }

                    case "__typename": {
                        responseData.put(key, jsonAsString(field.getValue(), key));
                        break;
                    }
                    default: {
                        throw new SchemaViolationError(this, key, field.getValue());
                    }
                }
            }
        }

        public String getGraphQlTypeName() {
            return "IntegerEntry";
        }

        public String getKey() {
            return (String) get("key");
        }

        public IntegerEntry setKey(String arg) {
            optimisticData.put("key", arg);
            return this;
        }

        public LocalDateTime getTtl() {
            return (LocalDateTime) get("ttl");
        }

        public IntegerEntry setTtl(LocalDateTime arg) {
            optimisticData.put("ttl", arg);
            return this;
        }

        public Integer getValue() {
            return (Integer) get("value");
        }

        public IntegerEntry setValue(Integer arg) {
            optimisticData.put("value", arg);
            return this;
        }

        public boolean unwrapsToObject(String key) {
            switch (getFieldName(key)) {
                case "key": return false;

                case "ttl": return false;

                case "value": return false;

                default: return false;
            }
        }
    }

    public enum KeyType {
        INTEGER,

        STRING,

        UNKNOWN_VALUE;

        public static KeyType fromGraphQl(String value) {
            if (value == null) {
                return null;
            }

            switch (value) {
                case "INTEGER": {
                    return INTEGER;
                }

                case "STRING": {
                    return STRING;
                }

                default: {
                    return UNKNOWN_VALUE;
                }
            }
        }
        public String toString() {
            switch (this) {
                case INTEGER: {
                    return "INTEGER";
                }

                case STRING: {
                    return "STRING";
                }

                default: {
                    return "";
                }
            }
        }
    }

    public interface MutationQueryDefinition {
        void define(MutationQuery _queryBuilder);
    }

    public static class MutationQuery extends Query<MutationQuery> {
        MutationQuery(StringBuilder _queryBuilder) {
            super(_queryBuilder);
        }

        public MutationQuery setInteger(SetIntegerInput input) {
            startField("set_integer");

            _queryBuilder.append("(input:");
            input.appendTo(_queryBuilder);

            _queryBuilder.append(')');

            return this;
        }

        public MutationQuery setString(String key, String value) {
            startField("set_string");

            _queryBuilder.append("(key:");
            Query.appendQuotedString(_queryBuilder, key.toString());

            _queryBuilder.append(",value:");
            Query.appendQuotedString(_queryBuilder, value.toString());

            _queryBuilder.append(')');

            return this;
        }

        public class SetStringWithDefaultArguments extends Arguments {
            SetStringWithDefaultArguments(StringBuilder _queryBuilder) {
                super(_queryBuilder, false);
            }

            public SetStringWithDefaultArguments value(String value) {
                if (value != null) {
                    startArgument("value");
                    Query.appendQuotedString(_queryBuilder, value.toString());
                }
                return this;
            }
        }

        public interface SetStringWithDefaultArgumentsDefinition {
            void define(SetStringWithDefaultArguments args);
        }

        public MutationQuery setStringWithDefault(String key) {
            return setStringWithDefault(key, args -> {});
        }

        public MutationQuery setStringWithDefault(String key, SetStringWithDefaultArgumentsDefinition argsDef) {
            startField("set_string_with_default");

            _queryBuilder.append("(key:");
            Query.appendQuotedString(_queryBuilder, key.toString());

            argsDef.define(new SetStringWithDefaultArguments(_queryBuilder));

            _queryBuilder.append(')');

            return this;
        }

        public String toString() {
            return _queryBuilder.toString();
        }
    }

    public static class Mutation extends AbstractResponse<Mutation> {
        public Mutation() {
        }

        public Mutation(JsonObject fields) throws SchemaViolationError {
            for (Map.Entry<String, JsonElement> field : fields.entrySet()) {
                String key = field.getKey();
                String fieldName = getFieldName(key);
                switch (fieldName) {
                    case "set_integer": {
                        responseData.put(key, jsonAsBoolean(field.getValue(), key));

                        break;
                    }

                    case "set_string": {
                        responseData.put(key, jsonAsBoolean(field.getValue(), key));

                        break;
                    }

                    case "set_string_with_default": {
                        responseData.put(key, jsonAsBoolean(field.getValue(), key));

                        break;
                    }

                    case "__typename": {
                        responseData.put(key, jsonAsString(field.getValue(), key));
                        break;
                    }
                    default: {
                        throw new SchemaViolationError(this, key, field.getValue());
                    }
                }
            }
        }

        public String getGraphQlTypeName() {
            return "Mutation";
        }

        public Boolean getSetInteger() {
            return (Boolean) get("set_integer");
        }

        public Mutation setSetInteger(Boolean arg) {
            optimisticData.put("set_integer", arg);
            return this;
        }

        public Boolean getSetString() {
            return (Boolean) get("set_string");
        }

        public Mutation setSetString(Boolean arg) {
            optimisticData.put("set_string", arg);
            return this;
        }

        public Boolean getSetStringWithDefault() {
            return (Boolean) get("set_string_with_default");
        }

        public Mutation setSetStringWithDefault(Boolean arg) {
            optimisticData.put("set_string_with_default", arg);
            return this;
        }

        public boolean unwrapsToObject(String key) {
            switch (getFieldName(key)) {
                case "set_integer": return false;

                case "set_string": return false;

                case "set_string_with_default": return false;

                default: return false;
            }
        }
    }

    public interface QueryRootQueryDefinition {
        void define(QueryRootQuery _queryBuilder);
    }

    public static class QueryRootQuery extends Query<QueryRootQuery> {
        QueryRootQuery(StringBuilder _queryBuilder) {
            super(_queryBuilder);
        }

        public class EntriesArguments extends Arguments {
            EntriesArguments(StringBuilder _queryBuilder) {
                super(_queryBuilder, false);
            }

            public EntriesArguments after(String value) {
                if (value != null) {
                    startArgument("after");
                    Query.appendQuotedString(_queryBuilder, value.toString());
                }
                return this;
            }
        }

        public interface EntriesArgumentsDefinition {
            void define(EntriesArguments args);
        }

        public QueryRootQuery entries(int first, EntryQueryDefinition queryDef) {
            return entries(first, args -> {}, queryDef);
        }

        public QueryRootQuery entries(int first, EntriesArgumentsDefinition argsDef, EntryQueryDefinition queryDef) {
            startField("entries");

            _queryBuilder.append("(first:");
            _queryBuilder.append(first);

            argsDef.define(new EntriesArguments(_queryBuilder));

            _queryBuilder.append(')');

            _queryBuilder.append('{');
            queryDef.define(new EntryQuery(_queryBuilder));
            _queryBuilder.append('}');

            return this;
        }

        public QueryRootQuery entry(String key, EntryQueryDefinition queryDef) {
            startField("entry");

            _queryBuilder.append("(key:");
            Query.appendQuotedString(_queryBuilder, key.toString());

            _queryBuilder.append(')');

            _queryBuilder.append('{');
            queryDef.define(new EntryQuery(_queryBuilder));
            _queryBuilder.append('}');

            return this;
        }

        public QueryRootQuery integer(String key) {
            startField("integer");

            _queryBuilder.append("(key:");
            Query.appendQuotedString(_queryBuilder, key.toString());

            _queryBuilder.append(')');

            return this;
        }

        public class KeysArguments extends Arguments {
            KeysArguments(StringBuilder _queryBuilder) {
                super(_queryBuilder, false);
            }

            public KeysArguments after(String value) {
                if (value != null) {
                    startArgument("after");
                    Query.appendQuotedString(_queryBuilder, value.toString());
                }
                return this;
            }

            public KeysArguments type(KeyType value) {
                if (value != null) {
                    startArgument("type");
                    _queryBuilder.append(value.toString());
                }
                return this;
            }
        }

        public interface KeysArgumentsDefinition {
            void define(KeysArguments args);
        }

        public QueryRootQuery keys(int first) {
            return keys(first, args -> {});
        }

        public QueryRootQuery keys(int first, KeysArgumentsDefinition argsDef) {
            startField("keys");

            _queryBuilder.append("(first:");
            _queryBuilder.append(first);

            argsDef.define(new KeysArguments(_queryBuilder));

            _queryBuilder.append(')');

            return this;
        }

        public QueryRootQuery string(String key) {
            startField("string");

            _queryBuilder.append("(key:");
            Query.appendQuotedString(_queryBuilder, key.toString());

            _queryBuilder.append(')');

            return this;
        }

        public QueryRootQuery ttl(String key) {
            startField("ttl");

            _queryBuilder.append("(key:");
            Query.appendQuotedString(_queryBuilder, key.toString());

            _queryBuilder.append(')');

            return this;
        }

        public QueryRootQuery type(String key) {
            startField("type");

            _queryBuilder.append("(key:");
            Query.appendQuotedString(_queryBuilder, key.toString());

            _queryBuilder.append(')');

            return this;
        }

        public QueryRootQuery version() {
            startField("version");

            return this;
        }

        public String toString() {
            return _queryBuilder.toString();
        }
    }

    public static class QueryRoot extends AbstractResponse<QueryRoot> {
        public QueryRoot() {
        }

        public QueryRoot(JsonObject fields) throws SchemaViolationError {
            for (Map.Entry<String, JsonElement> field : fields.entrySet()) {
                String key = field.getKey();
                String fieldName = getFieldName(key);
                switch (fieldName) {
                    case "entries": {
                        List<Entry> list1 = new ArrayList<>();
                        for (JsonElement element1 : jsonAsArray(field.getValue(), key)) {
                            list1.add(UnknownEntry.create(jsonAsObject(element1, key)));
                        }

                        responseData.put(key, list1);

                        break;
                    }

                    case "entry": {
                        Entry optional1 = null;
                        if (!field.getValue().isJsonNull()) {
                            optional1 = UnknownEntry.create(jsonAsObject(field.getValue(), key));
                        }

                        responseData.put(key, optional1);

                        break;
                    }

                    case "integer": {
                        Integer optional1 = null;
                        if (!field.getValue().isJsonNull()) {
                            optional1 = jsonAsInteger(field.getValue(), key);
                        }

                        responseData.put(key, optional1);

                        break;
                    }

                    case "keys": {
                        List<String> list1 = new ArrayList<>();
                        for (JsonElement element1 : jsonAsArray(field.getValue(), key)) {
                            list1.add(jsonAsString(element1, key));
                        }

                        responseData.put(key, list1);

                        break;
                    }

                    case "string": {
                        String optional1 = null;
                        if (!field.getValue().isJsonNull()) {
                            optional1 = jsonAsString(field.getValue(), key);
                        }

                        responseData.put(key, optional1);

                        break;
                    }

                    case "ttl": {
                        LocalDateTime optional1 = null;
                        if (!field.getValue().isJsonNull()) {
                            optional1 = LocalDateTime.parse(jsonAsString(field.getValue(), key));
                        }

                        responseData.put(key, optional1);

                        break;
                    }

                    case "type": {
                        KeyType optional1 = null;
                        if (!field.getValue().isJsonNull()) {
                            optional1 = KeyType.fromGraphQl(jsonAsString(field.getValue(), key));
                        }

                        responseData.put(key, optional1);

                        break;
                    }

                    case "version": {
                        String optional1 = null;
                        if (!field.getValue().isJsonNull()) {
                            optional1 = jsonAsString(field.getValue(), key);
                        }

                        responseData.put(key, optional1);

                        break;
                    }

                    case "__typename": {
                        responseData.put(key, jsonAsString(field.getValue(), key));
                        break;
                    }
                    default: {
                        throw new SchemaViolationError(this, key, field.getValue());
                    }
                }
            }
        }

        public String getGraphQlTypeName() {
            return "QueryRoot";
        }

        public List<Entry> getEntries() {
            return (List<Entry>) get("entries");
        }

        public QueryRoot setEntries(List<Entry> arg) {
            optimisticData.put("entries", arg);
            return this;
        }

        public Entry getEntry() {
            return (Entry) get("entry");
        }

        public QueryRoot setEntry(Entry arg) {
            optimisticData.put("entry", arg);
            return this;
        }

        public Integer getInteger() {
            return (Integer) get("integer");
        }

        public QueryRoot setInteger(Integer arg) {
            optimisticData.put("integer", arg);
            return this;
        }

        public List<String> getKeys() {
            return (List<String>) get("keys");
        }

        public QueryRoot setKeys(List<String> arg) {
            optimisticData.put("keys", arg);
            return this;
        }

        public String getString() {
            return (String) get("string");
        }

        public QueryRoot setString(String arg) {
            optimisticData.put("string", arg);
            return this;
        }

        public LocalDateTime getTtl() {
            return (LocalDateTime) get("ttl");
        }

        public QueryRoot setTtl(LocalDateTime arg) {
            optimisticData.put("ttl", arg);
            return this;
        }

        public KeyType getType() {
            return (KeyType) get("type");
        }

        public QueryRoot setType(KeyType arg) {
            optimisticData.put("type", arg);
            return this;
        }

        public String getVersion() {
            return (String) get("version");
        }

        public QueryRoot setVersion(String arg) {
            optimisticData.put("version", arg);
            return this;
        }

        public boolean unwrapsToObject(String key) {
            switch (getFieldName(key)) {
                case "entries": return false;

                case "entry": return false;

                case "integer": return false;

                case "keys": return false;

                case "string": return false;

                case "ttl": return false;

                case "type": return false;

                case "version": return false;

                default: return false;
            }
        }
    }

    public static class SetIntegerInput implements Serializable {
        private String key;

        private int value;

        private LocalDateTime ttl;

        private Boolean negate;

        public SetIntegerInput(String key, int value) {
            this.key = key;

            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public SetIntegerInput setKey(String key) {
            this.key = key;
            return this;
        }

        public int getValue() {
            return value;
        }

        public SetIntegerInput setValue(int value) {
            this.value = value;
            return this;
        }

        public LocalDateTime getTtl() {
            return ttl;
        }

        public SetIntegerInput setTtl(LocalDateTime ttl) {
            this.ttl = ttl;
            return this;
        }

        public Boolean getNegate() {
            return negate;
        }

        public SetIntegerInput setNegate(Boolean negate) {
            this.negate = negate;
            return this;
        }

        public void appendTo(StringBuilder _queryBuilder) {
            String separator = "";
            _queryBuilder.append('{');

            _queryBuilder.append(separator);
            separator = ",";
            _queryBuilder.append("key:");
            Query.appendQuotedString(_queryBuilder, key.toString());

            _queryBuilder.append(separator);
            separator = ",";
            _queryBuilder.append("value:");
            _queryBuilder.append(value);

            if (ttl != null) {
                _queryBuilder.append(separator);
                separator = ",";
                _queryBuilder.append("ttl:");
                Query.appendQuotedString(_queryBuilder, ttl.toString());
            }

            if (negate != null) {
                _queryBuilder.append(separator);
                separator = ",";
                _queryBuilder.append("negate:");
                _queryBuilder.append(negate);
            }

            _queryBuilder.append('}');
        }
    }

    public interface StringEntryQueryDefinition {
        void define(StringEntryQuery _queryBuilder);
    }

    public static class StringEntryQuery extends Query<StringEntryQuery> {
        StringEntryQuery(StringBuilder _queryBuilder) {
            super(_queryBuilder);
        }

        public StringEntryQuery key() {
            startField("key");

            return this;
        }

        public StringEntryQuery ttl() {
            startField("ttl");

            return this;
        }

        public StringEntryQuery value() {
            startField("value");

            return this;
        }
    }

    public static class StringEntry extends AbstractResponse<StringEntry> implements Entry {
        public StringEntry() {
        }

        public StringEntry(JsonObject fields) throws SchemaViolationError {
            for (Map.Entry<String, JsonElement> field : fields.entrySet()) {
                String key = field.getKey();
                String fieldName = getFieldName(key);
                switch (fieldName) {
                    case "key": {
                        responseData.put(key, jsonAsString(field.getValue(), key));

                        break;
                    }

                    case "ttl": {
                        LocalDateTime optional1 = null;
                        if (!field.getValue().isJsonNull()) {
                            optional1 = LocalDateTime.parse(jsonAsString(field.getValue(), key));
                        }

                        responseData.put(key, optional1);

                        break;
                    }

                    case "value": {
                        responseData.put(key, jsonAsString(field.getValue(), key));

                        break;
                    }

                    case "__typename": {
                        responseData.put(key, jsonAsString(field.getValue(), key));
                        break;
                    }
                    default: {
                        throw new SchemaViolationError(this, key, field.getValue());
                    }
                }
            }
        }

        public String getGraphQlTypeName() {
            return "StringEntry";
        }

        public String getKey() {
            return (String) get("key");
        }

        public StringEntry setKey(String arg) {
            optimisticData.put("key", arg);
            return this;
        }

        public LocalDateTime getTtl() {
            return (LocalDateTime) get("ttl");
        }

        public StringEntry setTtl(LocalDateTime arg) {
            optimisticData.put("ttl", arg);
            return this;
        }

        public String getValue() {
            return (String) get("value");
        }

        public StringEntry setValue(String arg) {
            optimisticData.put("value", arg);
            return this;
        }

        public boolean unwrapsToObject(String key) {
            switch (getFieldName(key)) {
                case "key": return false;

                case "ttl": return false;

                case "value": return false;

                default: return false;
            }
        }
    }
}
