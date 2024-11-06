package org.shaobig.jolt.mapper.transformer.type.jolt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.shaobig.jolt.mapper.transformer.type.classType.ClassTypeTransformer;
import org.shaobig.jolt.mapper.transformer.type.jolt.spec.JoltSpecTransformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassTypeJoltTransformerTest {

    private JoltSpecTransformer joltSpecTransformer;
    private ClassTypeTransformer classTypeTransformer;
    private ClassTypeJoltTransformer classTypeJoltTransformer;

    @BeforeEach
    void init() {
        this.joltSpecTransformer = Mockito.mock(JoltSpecTransformer.class);
        this.classTypeTransformer = Mockito.mock(ClassTypeTransformer.class);
        this.classTypeJoltTransformer = new ClassTypeJoltTransformer(joltSpecTransformer, classTypeTransformer);
    }

    @Test
    void transformClassTypeJoltTransformer() {
        Object sourceInput =  "INPUT_VALUE";
        classTypeJoltTransformer.transform(sourceInput);

        Object expected = "INPUT_VALUE";
        Mockito.verify(joltSpecTransformer).transform(expected);
    }

    @Test
    void transformJoltSpecTransformer() {
        Object sourceJoltSpecValue = "INPUT_VALUE";
        Mockito.when(joltSpecTransformer.transform(Mockito.any())).thenReturn(sourceJoltSpecValue);

        Object sourceInput = new Object();
        classTypeJoltTransformer.transform(sourceInput);

        Object expected = "INPUT_VALUE";
        Mockito.verify(classTypeTransformer).transform(expected);
    }

    @Test
    void transform() {
        Object sourceChainrResult = "INPUT_VALUE";
        Mockito.when(classTypeTransformer.transform(Mockito.any())).thenReturn(sourceChainrResult);

        Object sourceInput = new Object();
        Object actual = classTypeJoltTransformer.transform(sourceInput);

        Object expected = "INPUT_VALUE";
        assertEquals(expected, actual);
    }

}
