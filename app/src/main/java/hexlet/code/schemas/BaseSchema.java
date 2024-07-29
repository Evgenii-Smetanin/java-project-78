package hexlet.code.schemas;

public class BaseSchema<T> {
    protected boolean requiredFlg;

    public BaseSchema() {
        requiredFlg = false;
    }

    /**
     * required().
     * @return BaseSchema<T>
     */
    public BaseSchema<T> required() {
        requiredFlg = true;
        return this;
    }

    /**
     * isValid.
     * @return boolean
     * @param obj - T
     */
    public boolean isValid(T obj) {
        if (requiredFlg && obj == null) {
            return false;
        }

        return true;
    }
}
