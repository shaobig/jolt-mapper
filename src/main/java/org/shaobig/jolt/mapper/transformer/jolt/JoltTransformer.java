package org.shaobig.jolt.mapper.transformer.jolt;

import org.shaobig.jolt.mapper.transformer.Transformer;
import org.shaobig.jolt.mapper.transformer.jolt.spec.JoltSpecTransformer;

import java.util.Map;

public abstract class JoltTransformer<T> implements Transformer<T> {

    private JoltSpecTransformer<Object, Map<String, Object>> joltSpecTransformer;

    public JoltTransformer(JoltSpecTransformer<Object, Map<String, Object>> joltSpecTransformer) {
        this.joltSpecTransformer = joltSpecTransformer;
    }

    public JoltSpecTransformer<Object, Map<String, Object>> getJoltSpecTransformer() {
        return joltSpecTransformer;
    }

    public void setJoltSpecTransformer(JoltSpecTransformer<Object, Map<String, Object>> joltSpecTransformer) {
        this.joltSpecTransformer = joltSpecTransformer;
    }

}
