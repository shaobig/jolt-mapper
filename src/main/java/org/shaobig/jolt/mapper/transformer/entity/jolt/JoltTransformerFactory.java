package org.shaobig.jolt.mapper.transformer.entity.jolt;

import org.shaobig.jolt.mapper.transformer.entity.TransformerFactory;
import org.shaobig.jolt.mapper.transformer.entity.jolt.spec.JoltSpecTransformerFactory;

import java.util.Map;

public abstract class JoltTransformerFactory<T> implements TransformerFactory<T, JoltTransformer<T>> {

    private JoltSpecTransformerFactory<Object, Map<String, Object>> joltSpecTransformerFactory;

    public JoltTransformerFactory(JoltSpecTransformerFactory<Object, Map<String, Object>> joltSpecTransformerFactory) {
        this.joltSpecTransformerFactory = joltSpecTransformerFactory;
    }

    public JoltSpecTransformerFactory<Object, Map<String, Object>> getJoltSpecTransformerFactory() {
        return joltSpecTransformerFactory;
    }

    public void setJoltSpecTransformerFactory(JoltSpecTransformerFactory<Object, Map<String, Object>> joltSpecTransformerFactory) {
        this.joltSpecTransformerFactory = joltSpecTransformerFactory;
    }

}
