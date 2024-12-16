package org.shaobig.jolt.mapper.transformer.type.typeReference;

import com.fasterxml.jackson.core.type.TypeReference;
import org.shaobig.jolt.mapper.transformer.TransformerFactory;

public abstract class TypeReferenceTransformerFactory<T> implements TransformerFactory<T, TypeReferenceTransformer<T>> {

    private TypeReference<T> typeReference;

    public TypeReferenceTransformerFactory(TypeReference<T> typeReference) {
        this.typeReference = typeReference;
    }

    public TypeReference<T> getTypeReference() {
        return typeReference;
    }

    public void setTypeReference(TypeReference<T> typeReference) {
        this.typeReference = typeReference;
    }

}
