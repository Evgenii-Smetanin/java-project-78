package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema() {
    }

    public NumberSchema positive() {
        addCheck(
                "positive",
                value -> value == null || value > 0
        );

        return this;
    }

    public NumberSchema range(int minimum, int maximum) {
        if (minimum > maximum) {
            throw new IllegalArgumentException("Min value should be <= max value");
        }

        addCheck(
                "range",
                value -> value == null || value >= minimum && value <= maximum
        );

        return this;
    }
}
