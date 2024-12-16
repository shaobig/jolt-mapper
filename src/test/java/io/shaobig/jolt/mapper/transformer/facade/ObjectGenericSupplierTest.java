package io.shaobig.jolt.mapper.transformer.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.shaobig.jolt.mapper.transformer.type.jolt.facade.ObjectGenericSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectGenericSupplierTest {

    private String entity;
    private ObjectGenericSupplier<String> objectGenericSupplier;

    @BeforeEach
    void init() {
        this.entity = "INPUT_VALUE";
        this.objectGenericSupplier = new ObjectGenericSupplier<>(entity);
    }

    @Test
    void get() {
        String actual = objectGenericSupplier.get();

        String expected = "INPUT_VALUE";
        assertEquals(expected, actual);
    }

}
