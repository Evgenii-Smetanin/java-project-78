package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema() {
    }

    public StringSchema minLength(int min) {
        if (min <= 0) {
            throw new IllegalArgumentException("Minimal length must be > 0");
        }

        addCheck(
                "minLength",
                value -> value == null || value.length() >= min
        );

        return this;
    }

    public StringSchema contains(String s) {
        if (s.isEmpty()) {
            throw new IllegalArgumentException("Substring must be non-null and have a length of > 0");
        }

        addCheck(
                "contains",
                value -> value == null || value.contains(s)
        );

        return this;
    }

    @Override
    public StringSchema required() {
        addCheck(
                "required",
                value -> value != null && !value.isEmpty()
        );

        return this;
    }
}
