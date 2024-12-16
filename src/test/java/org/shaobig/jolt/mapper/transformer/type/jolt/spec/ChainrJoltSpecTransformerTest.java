package org.shaobig.jolt.mapper.transformer.type.jolt.spec;

import com.bazaarvoice.jolt.Chainr;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.shaobig.jolt.mapper.transformer.type.chainr.ChainrSupplier;
import org.shaobig.jolt.mapper.transformer.type.typeReference.TypeReferenceTransformer;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChainrJoltSpecTransformerTest {

    private ChainrSupplier chainrSupplier;
    private TypeReferenceTransformer<Map<String, Object>> typeReferenceTransformer;
    private ChainrJoltSpecTransformer chainrJoltSpecTransformer;

    @BeforeEach
    void init() {
        this.chainrSupplier = Mockito.mock(ChainrSupplier.class);
        this.typeReferenceTransformer = Mockito.mock(TypeReferenceTransformer.class);
        this.chainrJoltSpecTransformer = new ChainrJoltSpecTransformer(chainrSupplier, typeReferenceTransformer);
    }

    @Test
    void transformTypeReferenceTransformer() {
        Chainr sourceChainr = Mockito.mock(Chainr.class);
        Mockito.when(chainrSupplier.get()).thenReturn(sourceChainr);

        Object sourceInput = "INPUT_VALUE";
        chainrJoltSpecTransformer.transform(sourceInput);

        Object expected = "INPUT_VALUE";
        Mockito.verify(typeReferenceTransformer).transform(expected);
    }

    @Test
    void transformChainr() {
        Chainr sourceChainr = Mockito.mock(Chainr.class);
        Map<String, Object> sourceStringObjectMap = Map.of("SOURCE_KEY", "SOURCE_VALUE");
        Mockito.when(chainrSupplier.get()).thenReturn(sourceChainr);
        Mockito.when(typeReferenceTransformer.transform(Mockito.any())).thenReturn(sourceStringObjectMap);

        Object sourceInput = new Object();
        chainrJoltSpecTransformer.transform(sourceInput);

        Map<String, Object> expected = Map.of("SOURCE_KEY", "SOURCE_VALUE");
        Mockito.verify(chainrSupplier.get()).transform(expected);
    }

    @Test
    void transform() {
        Chainr sourceChainr = Mockito.mock(Chainr.class);
        Object sourceChainrResult = "INPUT_VALUE";
        Mockito.when(chainrSupplier.get()).thenReturn(sourceChainr);
        Mockito.when(sourceChainr.transform(Mockito.any())).thenReturn(sourceChainrResult);

        Object sourceInput = new Object();
        Object actual = chainrJoltSpecTransformer.transform(sourceInput);

        Object expected = "INPUT_VALUE";
        assertEquals(expected, actual);
    }

}
