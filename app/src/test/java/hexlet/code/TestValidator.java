package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestValidator {
    Validator v;

    @BeforeEach
    void init() {
        v = new Validator();
    }

    @Test
    void testString() {
        StringSchema schema = v.string();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("what does the fox say"));

        assertTrue(schema.contains("wh").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));

        StringSchema schema1 = v.string();
        assertTrue(schema1.minLength(10).minLength(4).isValid("Hexlet"));
        assertFalse(schema.isValid("foo"));
    }
}
