package org.shaobig.jolt.mapper;

import org.shaobig.jolt.mapper.facade.FacadeJoltTransformerSupplier;
import org.shaobig.jolt.mapper.transformer.entity.Transformer;
import org.shaobig.jolt.mapper.transformer.entity.jolt.JoltTransformer;

public class JoltMapper<T> implements Transformer<T> {

    private JoltTransformer<T> joltTransformer;

    private JoltMapper(JoltTransformer<T> joltTransformer) {
        this.joltTransformer = joltTransformer;
    }

    public static <T> JoltMapper<T> create(String path, Class<T> classType) {
        return new JoltMapper<>(new FacadeJoltTransformerSupplier<>(path, classType).get());
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
