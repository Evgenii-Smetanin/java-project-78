package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean positiveFlg;
    private boolean rangeFlg;

    private int min;
    private int max;

    public NumberSchema() {
        positiveFlg = false;
        rangeFlg = false;

        min = 0;
        max = 0;
    }

    public NumberSchema positive() {
        positiveFlg = true;
        return this;
    }

    public NumberSchema range(int minimum, int maximum) {
        if (minimum > maximum) {
            throw new IllegalArgumentException("Min value should be <= max value");
        }

        rangeFlg = true;
        min = minimum;
        max = maximum;
        return this;
    }

    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

    @Override
    public boolean isValid(Integer num) {
        if (!super.isValid(num)) {
            return false;
        }

        if (positiveFlg && (num != null && num <= 0)) {
            return false;
        }

        if (rangeFlg && num != null && (num < min || num > max)) {
            return false;
        }

        return true;
    }
}
