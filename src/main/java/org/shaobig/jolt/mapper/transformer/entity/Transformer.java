package org.shaobig.jolt.mapper.transformer.entity;

public interface Transformer<T> {

    T transform(Object input);

}
