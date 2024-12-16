package io.shaobig.jolt.mapper.transformer.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import io.shaobig.jolt.mapper.transformer.type.jolt.JoltTransformer;
import io.shaobig.jolt.mapper.transformer.type.jolt.facade.FacadeProxyJoltTransformerFactory;
import io.shaobig.jolt.mapper.transformer.type.jolt.facade.ObjectGenericSupplier;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FacadeProxyJoltTransformerFactoryTest {

    private Supplier<String> pathSupplier;
    private Supplier<Class<Object>> classSupplier;
    private FacadeProxyJoltTransformerFactory<Object> facadeProxyJoltTransformerFactory;

    @BeforeEach
    void init() {
        this.pathSupplier = Mockito.mock(ObjectGenericSupplier.class);
        this.classSupplier = Mockito.mock(ObjectGenericSupplier.class);
        this.facadeProxyJoltTransformerFactory = new FacadeProxyJoltTransformerFactory<>(pathSupplier, classSupplier);
    }

    @Test
    void getTransformer() {
        Mockito.when(pathSupplier.get()).thenReturn("/io/shaobig/jolt/mapper/transformer/facade/source-file.json");
        Mockito.when(classSupplier.get()).thenReturn(Object.class);

        JoltTransformer<Object> actual = facadeProxyJoltTransformerFactory.getTransformer();

        JoltTransformer<Object> expected = new FacadeProxyJoltTransformerFactory<>(new ObjectGenericSupplier<>("/io/shaobig/jolt/mapper/transformer/facade/source-file.json"), new ObjectGenericSupplier<>(Object.class)).getTransformer();
        assertEquals(expected, actual);
    }

}
