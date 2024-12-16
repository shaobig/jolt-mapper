package io.shaobig.jolt.mapper.transformer.type.typeReference;

import com.fasterxml.jackson.core.type.TypeReference;
import io.shaobig.jolt.mapper.transformer.Transformer;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeReferenceTransformer<?> that = (TypeReferenceTransformer<?>) o;
        return Objects.equals(getTypeReference().getType(), that.getTypeReference().getType());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(typeReference);
    }

}
