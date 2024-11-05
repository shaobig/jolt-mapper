package org.shaobig.jolt.mapper.transformer.classType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectMapperClassTypeTransformerTest {

    private ObjectMapperClassTypeTransformer<ResponseEntity> objectMapperClassTypeTransformer;

    @BeforeEach
    void init() {
        this.objectMapperClassTypeTransformer = new ObjectMapperClassTypeTransformer<>(ResponseEntity.class);
    }

    @Test
    void transform() {
        Object sourceInput = new RequestEntity("SOURCE_VALUE");
        ResponseEntity actual = objectMapperClassTypeTransformer.transform(sourceInput);

        ResponseEntity expected = new ResponseEntity("SOURCE_VALUE");
        assertEquals(expected, actual);
    }

    private record RequestEntity(String value) {}

    private record ResponseEntity(String value) {}

}
