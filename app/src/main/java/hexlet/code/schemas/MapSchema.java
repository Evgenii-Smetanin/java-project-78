package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema<K, V> extends BaseSchema<Map<K, V>> {
    public MapSchema() {

    }

    public MapSchema<K, V> sizeof(int mapSize) {
        addCheck(
                "sizeof",
                value -> value == null || value.size() == mapSize
        );

        return this;
    }

    public MapSchema<K, V> shape(Map<String, BaseSchema<String>> schemaMap) {
        if (schemaMap == null) {
            throw new IllegalArgumentException("Schema must be non-null");
        }

        schemaMap.forEach((k, v) -> addCheck(
                "shape",
                value -> v.isValid((String) value.getOrDefault(k, null))
        ));

        return this;
    }
}
