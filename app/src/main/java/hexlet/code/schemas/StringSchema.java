package hexlet.code.schemas;

public class StringSchema {
    private boolean requiredFlg;
    private boolean minLengthFlg;
    private boolean substringFlg;

    private int minLength;
    private String substring;

    public StringSchema() {
        requiredFlg = false;
        minLengthFlg = false;
        substringFlg = false;
        minLength = 0;
        substring = "";
    }

    public StringSchema required() {
        requiredFlg = true;
        return this;
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
        if (substring.isEmpty()) {
            throw new IllegalArgumentException("Substring must be non-null and have a length of > 0");
        }

        substringFlg = true;
        substring = s;
        return this;
    }

    public boolean isValid(String string) {
        if (requiredFlg && string.isEmpty()) {
            return false;
        }

        if (minLengthFlg && (string.isEmpty() || string.length() < minLength)) {
            return false;
        }

        if (substringFlg && (string.isEmpty() || !string.contains(substring))) {
            return false;
        }
        return true;
    }
}
