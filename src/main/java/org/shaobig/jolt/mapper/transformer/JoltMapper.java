package org.shaobig.jolt.mapper.transformer;

import org.shaobig.jolt.mapper.transformer.type.jolt.JoltTransformer;
import org.shaobig.jolt.mapper.transformer.type.jolt.facade.FacadeProxyJoltTransformerFactory;
import org.shaobig.jolt.mapper.transformer.type.jolt.facade.ObjectGenericSupplier;

public class JoltMapper<T> implements Transformer<T> {

    private JoltTransformer<T> joltTransformer;

    JoltMapper(JoltTransformer<T> joltTransformer) {
        this.joltTransformer = joltTransformer;
    }

    public static <T> JoltMapper<T> create(String path, Class<T> classType) {
        return new JoltMapper<>(new FacadeProxyJoltTransformerFactory<>(new ObjectGenericSupplier<>(path), new ObjectGenericSupplier<>(classType)).getTransformer());
    }

    @Override
    public T transform(Object input) {
        return getJoltTransformer().transform(input);
    }

    public JoltTransformer<T> getJoltTransformer() {
        return joltTransformer;
    }

    public void setJoltTransformer(JoltTransformer<T> joltTransformer) {
        this.joltTransformer = joltTransformer;
    }

}
