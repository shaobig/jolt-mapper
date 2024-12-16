package io.shaobig.jolt.mapper.transformer.type.typeReference;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectMapperTypeReferenceTransformerTest {

    private ObjectMapperTypeReferenceTransformer<String> objectMapperTypeReferenceTransformer;

    @BeforeEach
    void init() {
        this.objectMapperTypeReferenceTransformer = new ObjectMapperTypeReferenceTransformer<>(new TypeReference<>() {});
    }
    
    @Test
    void transform() {
        String sourceInput = "INPUT_VALUE";
        String actual = objectMapperTypeReferenceTransformer.transform(sourceInput);

        String expected = "INPUT_VALUE";
        assertEquals(expected, actual);
    }

}
