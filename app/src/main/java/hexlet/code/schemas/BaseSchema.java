package hexlet.code.schemas;

public class BaseSchema<T> {
    protected boolean requiredFlg;

    public BaseSchema() {
        requiredFlg = false;
    }

    /**
     * Выполняет проверку переданного объекта в соответствии со схемой валидации.
     * @return true, если проверка пройдена, иначе false.
     */
    public BaseSchema<T> required() {
        requiredFlg = true;
        return this;
    }

    /**
     * добавляет в схему валидации проверку валидируемого объекта на null.
     * @return объект схемы.
     * @param obj - валидируемый объект.
     */
    public boolean isValid(T obj) {
        if (requiredFlg && obj == null) {
            return false;
        }

        return true;
    }
}
