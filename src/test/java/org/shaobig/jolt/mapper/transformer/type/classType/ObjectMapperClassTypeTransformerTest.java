package org.shaobig.jolt.mapper.transformer.type.classType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectMapperClassTypeTransformerTest {

    private ObjectMapperClassTypeTransformer<String> objectMapperClassTypeTransformer;

    @BeforeEach
    void init() {
        this.objectMapperClassTypeTransformer = new ObjectMapperClassTypeTransformer<>(String.class);
    }

    @Test
    void transform() {
        String sourceInput = "INPUT_VALUE";
        String actual = objectMapperClassTypeTransformer.transform(sourceInput);

        String expected = "INPUT_VALUE";
        assertEquals(expected, actual);
    }

}
