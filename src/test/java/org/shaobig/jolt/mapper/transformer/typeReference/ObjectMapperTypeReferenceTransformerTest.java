package org.shaobig.jolt.mapper.transformer.typeReference;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectMapperTypeReferenceTransformerTest {

    private ObjectMapperTypeReferenceTransformer<ResponseEntity> objectMapperTypeReferenceTransformer;

    @BeforeEach
    void init() {
        this.objectMapperTypeReferenceTransformer = new ObjectMapperTypeReferenceTransformer<>(new TypeReference<ResponseEntity>() {});
    }
    
    @Test
    void transform() {
        Object sourceInput = new RequestEntity("SOURCE_VALUE");
        ResponseEntity actual = objectMapperTypeReferenceTransformer.transform(sourceInput);

        ResponseEntity expected = new ResponseEntity("SOURCE_VALUE");
        assertEquals(expected, actual);
    }

    private record RequestEntity(String value) {}
    
    private record ResponseEntity(String value) {}

}
