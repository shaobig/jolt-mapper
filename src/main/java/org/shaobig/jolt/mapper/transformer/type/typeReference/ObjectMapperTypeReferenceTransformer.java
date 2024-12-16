package org.shaobig.jolt.mapper.transformer.type.typeReference;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperTypeReferenceTransformer<T> extends TypeReferenceTransformer<T> {

    public ObjectMapperTypeReferenceTransformer(TypeReference<T> typeReference) {
        super(typeReference);
    }

    @Override
    public T transform(Object input) {
        return new ObjectMapper().convertValue(input, getTypeReference());
    }

}
