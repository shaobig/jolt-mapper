package org.shaobig.jolt.mapper.transformer.entity;

public interface TransformerFactory<T, R extends Transformer<T>> {

    R getTransformer();

}
