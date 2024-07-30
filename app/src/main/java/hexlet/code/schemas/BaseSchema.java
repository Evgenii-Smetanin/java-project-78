package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    public BaseSchema() {
    }

    protected final void addCheck(String name, Predicate<T> validate) {
        checks.put(name, validate);
    }

    /**
     * Выполняет проверку переданного объекта в соответствии со схемой валидации.
     *
     * @return true, если проверка пройдена, иначе false.
     */
    public BaseSchema<T> required() {
        addCheck(
                "required",
                Objects::nonNull
        );
        return this;
    }

    /**
     * добавляет в схему валидации проверку валидируемого объекта на null.
     *
     * @param value - валидируемый объект.
     * @return объект схемы.
     */
    public final boolean isValid(T value) {
        var result = new Object() {
            private boolean isValid = true;
        };

        checks.forEach((k, v) -> {
            if (!v.test(value)) {
                result.isValid = false;
            }
        });

        return result.isValid;
    }
}
