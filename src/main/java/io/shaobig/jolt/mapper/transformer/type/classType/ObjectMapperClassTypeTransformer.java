package io.shaobig.jolt.mapper.transformer.type.classType;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperClassTypeTransformer<T> extends ClassTypeTransformer<T> {

    public ObjectMapperClassTypeTransformer(Class<T> returnClass) {
        super(returnClass);
    }

    @Override
    public T transform(Object input) {
        return new ObjectMapper().convertValue(input, getReturnClass());
    }

}
