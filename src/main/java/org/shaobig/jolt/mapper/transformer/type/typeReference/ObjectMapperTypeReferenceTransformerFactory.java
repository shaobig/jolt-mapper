package org.shaobig.jolt.mapper.transformer.type.typeReference;

import com.fasterxml.jackson.core.type.TypeReference;

public class ObjectMapperTypeReferenceTransformerFactory<T> extends TypeReferenceTransformerFactory<T> {

    public ObjectMapperTypeReferenceTransformerFactory(TypeReference<T> typeReference) {
        super(typeReference);
    }

    @Override
    public TypeReferenceTransformer<T> getTransformer() {
        return new ObjectMapperTypeReferenceTransformer<>(getTypeReference());
    }

}
