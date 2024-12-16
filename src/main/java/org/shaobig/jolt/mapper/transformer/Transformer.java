package org.shaobig.jolt.mapper.transformer;

public interface Transformer<T> {

    T transform(Object input);

}
