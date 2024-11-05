package org.shaobig.jolt.mapper.transformer.jolt.spec;

import com.bazaarvoice.jolt.Chainr;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.shaobig.jolt.mapper.transformer.typeReference.TypeReferenceTransformer;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChainrJoltSpecTransformerTest {

    private Chainr chainr;
    private TypeReferenceTransformer<Map<String, Object>> typeReferenceTransformer;
    private ChainrJoltSpecTransformer chainrJoltSpecTransformer;

    @BeforeEach
    void init() {
        this.chainr = Mockito.mock(Chainr.class);
        this.typeReferenceTransformer = Mockito.mock(TypeReferenceTransformer.class);
        this.chainrJoltSpecTransformer = new ChainrJoltSpecTransformer(chainr, typeReferenceTransformer);
    }

    @Test
    void transformTypeReferenceTransformer() {
        Object sourceInput = "INPUT_VALUE";
        chainrJoltSpecTransformer.transform(sourceInput);

        Object expected = "INPUT_VALUE";
        Mockito.verify(typeReferenceTransformer).transform(expected);
    }

    @Test
    void transformChainr() {
        Map<String, Object> sourceStringObjectMap = Map.of("SOURCE_KEY", "SOURCE_VALUE");
        Mockito.when(typeReferenceTransformer.transform(Mockito.any())).thenReturn(sourceStringObjectMap);

        Object sourceInput = new Object();
        chainrJoltSpecTransformer.transform(sourceInput);

        Map<String, Object> expected = Map.of("SOURCE_KEY", "SOURCE_VALUE");
        Mockito.verify(chainr).transform(expected);
    }

    @Test
    void transform() {
        Object sourceChainrResult = "INPUT_VALUE";
        Mockito.when(chainr.transform(Mockito.any())).thenReturn(sourceChainrResult);

        Object sourceInput = new Object();
        Object actual = chainrJoltSpecTransformer.transform(sourceInput);

        Object expected = "INPUT_VALUE";
        assertEquals(expected, actual);
    }

}
