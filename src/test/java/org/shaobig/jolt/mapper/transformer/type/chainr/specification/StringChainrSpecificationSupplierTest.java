package org.shaobig.jolt.mapper.transformer.type.chainr.specification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.shaobig.jolt.mapper.transformer.type.chainr.specification.StringChainrSpecificationSupplier;

import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringChainrSpecificationSupplierTest {

    private Supplier<String> pathSupplier;
    private StringChainrSpecificationSupplier stringChainrSpecificationSupplier;

    @BeforeEach
    void init() {
        this.pathSupplier = Mockito.mock(Supplier.class);
        this.stringChainrSpecificationSupplier = new StringChainrSpecificationSupplier(pathSupplier);
    }

    @Test
    void get() {
        String sourcePath = "/org/shaobig/jolt/mapper/transformer/chainr/specification/source-specification.json";
        Mockito.when(pathSupplier.get()).thenReturn(sourcePath);

        List<String> actual = stringChainrSpecificationSupplier.get().stream()
                .map(Object::toString)
                .toList();

        List<String> expected = List.of("{operation=shift, spec={INPUT_KEY=OUTPUT_KEY}}", "{operation=default, spec={DEFAULT_KEY=DEFAULT_VALUE}}");
        assertEquals(expected, actual);
    }

}
