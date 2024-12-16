package org.shaobig.jolt.mapper.transformer;

public interface TransformerFactory<T, R extends Transformer<T>> {

    R getTransformer();

}
