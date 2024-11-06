package org.shaobig.jolt.mapper.transformer.type.jolt;

import org.shaobig.jolt.mapper.transformer.Transformer;
import org.shaobig.jolt.mapper.transformer.type.jolt.spec.JoltSpecTransformer;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoltTransformer<?> that = (JoltTransformer<?>) o;
        return Objects.equals(joltSpecTransformer, that.joltSpecTransformer);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(joltSpecTransformer);
    }

}
