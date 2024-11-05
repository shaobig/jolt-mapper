package org.shaobig.jolt.mapper.transformer.jolt;

import org.shaobig.jolt.mapper.transformer.TransformerFactory;
import org.shaobig.jolt.mapper.transformer.jolt.spec.JoltSpecTransformerFactory;

public abstract class JoltTransformerFactory<T> implements TransformerFactory<T, JoltTransformer<T>> {

    private JoltSpecTransformerFactory<Object> joltSpecTransformerFactory;

    public JoltTransformerFactory(JoltSpecTransformerFactory<Object> joltSpecTransformerFactory) {
        this.joltSpecTransformerFactory = joltSpecTransformerFactory;
    }

    public JoltSpecTransformerFactory<Object> getJoltSpecTransformerFactory() {
        return joltSpecTransformerFactory;
    }

    public void setJoltSpecTransformerFactory(JoltSpecTransformerFactory<Object> joltSpecTransformerFactory) {
        this.joltSpecTransformerFactory = joltSpecTransformerFactory;
    }

}
