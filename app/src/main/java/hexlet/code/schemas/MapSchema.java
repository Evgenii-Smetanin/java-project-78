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

    public <T> MapSchema<K, V> shape(Map<String, BaseSchema<T>> schemaMap) {
        if (schemaMap == null) {
            throw new IllegalArgumentException("Schema must be non-null");
        }

        addCheck(
                "shape",
                map -> schemaMap.entrySet().stream().allMatch(e -> {
                    var v = map.get(e.getKey());
                    var schema = e.getValue();
                    return schema.isValid((T) v);
                })
        );

        return this;
    }
}
