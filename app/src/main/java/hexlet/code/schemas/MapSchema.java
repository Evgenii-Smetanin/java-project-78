package hexlet.code.schemas;

import java.util.Map;

public class MapSchema<K, V> extends BaseSchema<Map<K, V>> {
    private boolean sizeOfFlg;
    private boolean schemasFlg;

    private int size;
    private Map<String, BaseSchema<String>> schemas;

    public MapSchema() {
        sizeOfFlg = false;
        schemasFlg = false;
        size = 0;
        schemas = null;
    }

    /**
     * sizeof.
     * @param mapSize - int
     * @return MapSchema<K, V>
     */
    public MapSchema<K, V> sizeof(int mapSize) {
        sizeOfFlg = true;
        size = mapSize;
        return this;
    }

    /**
     * shape.
     * @param schemaMap - Map<String, BaseSchema<String>>
     * @return MapSchema<K, V>
     */
    public MapSchema<K, V> shape(Map<String, BaseSchema<String>> schemaMap) {
        if (schemaMap == null) {
            throw new IllegalArgumentException("Schema must be non-null");
        }

        schemasFlg = true;
        schemas = schemaMap;
        return this;
    }

    /**
     * required.
     * @return MapSchema<K, V>
     */
    @Override
    public MapSchema<K, V> required() {
        super.required();
        return this;
    }

    /**
     * isValid.
     * @return boolean
     */
    @Override
    public boolean isValid(Map<K, V> map) {
        if (!super.isValid(map)) {
            return false;
        }

        if (sizeOfFlg && map != null && map.size() != size) {
            return false;
        }

        var wrapper = new Object() {
            public Boolean result = true;
        };

        if (schemasFlg && map != null) {
            schemas.forEach((k, v) -> {
                if (!v.isValid((String) map.getOrDefault(k, null))) {
                    wrapper.result = false;
                }
            });
        }

        return wrapper.result;
    }
}
