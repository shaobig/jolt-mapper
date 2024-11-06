package org.shaobig.jolt.mapper.transformer.type.jolt.spec;

import org.shaobig.jolt.mapper.transformer.Transformer;
import org.shaobig.jolt.mapper.transformer.type.chainr.ChainrSupplier;
import org.shaobig.jolt.mapper.transformer.type.typeReference.TypeReferenceTransformer;

import java.util.Map;
import java.util.Objects;

public abstract class JoltSpecTransformer<T> implements Transformer<T> {

    private ChainrSupplier chainrSupplier;
    private TypeReferenceTransformer<Map<String, Object>> typeReferenceTransformer;

    public JoltSpecTransformer(ChainrSupplier chainrSupplier, TypeReferenceTransformer<Map<String, Object>> typeReferenceTransformer) {
        this.chainrSupplier = chainrSupplier;
        this.typeReferenceTransformer = typeReferenceTransformer;
    }

    public ChainrSupplier getChainrSupplier() {
        return chainrSupplier;
    }

    public void setChainrSupplier(ChainrSupplier chainrSupplier) {
        this.chainrSupplier = chainrSupplier;
    }

    public TypeReferenceTransformer<Map<String, Object>> getTypeReferenceTransformer() {
        return typeReferenceTransformer;
    }

    public void setTypeReferenceTransformer(TypeReferenceTransformer<Map<String, Object>> typeReferenceTransformer) {
        this.typeReferenceTransformer = typeReferenceTransformer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoltSpecTransformer<?> that = (JoltSpecTransformer<?>) o;
        return Objects.equals(chainrSupplier, that.chainrSupplier) && Objects.equals(typeReferenceTransformer, that.typeReferenceTransformer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chainrSupplier, typeReferenceTransformer);
    }

}
