package org.shaobig.jolt.mapper.transformer.jolt;

import org.shaobig.jolt.mapper.transformer.Transformer;
import org.shaobig.jolt.mapper.transformer.jolt.spec.JoltSpecTransformer;

import java.util.Map;

public abstract class JoltTransformer<T> implements Transformer<T> {

    private JoltSpecTransformer<Object> joltSpecTransformer;

    public JoltTransformer(JoltSpecTransformer<Object> joltSpecTransformer) {
        this.joltSpecTransformer = joltSpecTransformer;
    }

    public JoltSpecTransformer<Object> getJoltSpecTransformer() {
        return joltSpecTransformer;
    }

    public void setJoltSpecTransformer(JoltSpecTransformer<Object> joltSpecTransformer) {
        this.joltSpecTransformer = joltSpecTransformer;
    }

}
