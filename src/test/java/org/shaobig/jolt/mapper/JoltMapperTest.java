package org.shaobig.jolt.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.shaobig.jolt.mapper.transformer.type.jolt.JoltTransformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JoltMapperTest {

    private JoltTransformer<String> joltTransformer;
    private JoltMapper<String> joltMapper;

    @BeforeEach
    void init() {
        this.joltTransformer = Mockito.mock(JoltTransformer.class);
        this.joltMapper = new JoltMapper<>(joltTransformer);
    }

    @Test
    void transformInput() {
        String sourceInput = "INPUT_VALUE";
        joltMapper.transform(sourceInput);

        String expected = "INPUT_VALUE";
        Mockito.verify(joltTransformer).transform(expected);
    }

    @Test
    void transform() {
        String sourceJoltTransformerOutput = "INPUT_VALUE";
        Mockito.when(joltTransformer.transform(Mockito.any())).thenReturn(sourceJoltTransformerOutput);

        String sourceInput = "";
        String actual = joltMapper.transform(sourceInput);

        String expected = "INPUT_VALUE";
        assertEquals(expected, actual);
    }

}
