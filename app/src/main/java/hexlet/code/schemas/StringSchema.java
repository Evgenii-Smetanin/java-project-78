package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    private boolean minLengthFlg;
    private boolean substringFlg;

    private int minLength;
    private String substring;

    public StringSchema() {
        minLengthFlg = false;
        substringFlg = false;
        minLength = 0;
        substring = "";
    }

    public StringSchema minLength(int min) {
        if (min <= 0) {
            throw new IllegalArgumentException("Minimal length must be > 0");
        }

        minLengthFlg = true;
        minLength = min;
        return this;
    }

    public StringSchema contains(String s) {
        if (s.isEmpty()) {
            throw new IllegalArgumentException("Substring must be non-null and have a length of > 0");
        }

        substringFlg = true;
        substring = s;
        return this;
    }

    @Override
    public StringSchema required() {
        super.required();
        return this;
    }

    @Override
    public boolean isValid(String string) {
        if (!super.isValid(string)) {
            return false;
        }

        if (requiredFlg && string.isEmpty()
        ) {
            return false;
        }

        if (minLengthFlg && (string == null || string.isEmpty() || string.length() < minLength)) {
            return false;
        }

        if (substringFlg && (string == null || string.isEmpty() || !string.contains(substring))) {
            return false;
        }

        return true;
    }
}
