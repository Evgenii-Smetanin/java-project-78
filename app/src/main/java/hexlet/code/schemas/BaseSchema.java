package hexlet.code.schemas;

public class BaseSchema<T> {
    protected boolean requiredFlg;

    public BaseSchema() {
        requiredFlg = false;
    }

    public BaseSchema<T> required() {
        requiredFlg = true;
        return this;
    }

    public boolean isValid(T obj) {
        if (requiredFlg && obj == null) {
            return false;
        }

        return true;
    }
}
