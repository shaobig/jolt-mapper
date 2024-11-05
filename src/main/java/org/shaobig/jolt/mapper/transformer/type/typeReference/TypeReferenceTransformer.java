package org.shaobig.jolt.mapper.transformer.type.typeReference;

import com.fasterxml.jackson.core.type.TypeReference;
import org.shaobig.jolt.mapper.transformer.Transformer;

public abstract class TypeReferenceTransformer<T> implements Transformer<T> {

    private TypeReference<T> typeReference;

    public TypeReferenceTransformer(TypeReference<T> typeReference) {
        this.typeReference = typeReference;
    }

    public TypeReference<T> getTypeReference() {
        return typeReference;
    }

    public void setTypeReference(TypeReference<T> typeReference) {
        this.typeReference = typeReference;
    }

}
