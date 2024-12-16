package org.shaobig.jolt.mapper.transformer.type.jolt.spec;

import org.shaobig.jolt.mapper.transformer.TransformerFactory;
import org.shaobig.jolt.mapper.transformer.type.chainr.ChainrSupplier;
import org.shaobig.jolt.mapper.transformer.type.typeReference.TypeReferenceTransformerFactory;

import java.util.Map;

public abstract class JoltSpecTransformerFactory<T> implements TransformerFactory<T, JoltSpecTransformer<T>> {

    private ChainrSupplier chainrSupplier;
    private TypeReferenceTransformerFactory<Map<String, Object>> typeReferenceTransformerFactory;

    public JoltSpecTransformerFactory(ChainrSupplier chainrSupplier, TypeReferenceTransformerFactory<Map<String, Object>> typeReferenceTransformerFactory) {
        this.chainrSupplier = chainrSupplier;
        this.typeReferenceTransformerFactory = typeReferenceTransformerFactory;
    }

    public ChainrSupplier getChainrSupplier() {
        return chainrSupplier;
    }

    public void setChainrSupplier(ChainrSupplier chainrSupplier) {
        this.chainrSupplier = chainrSupplier;
    }

    public TypeReferenceTransformerFactory<Map<String, Object>> getTypeReferenceTransformerFactory() {
        return typeReferenceTransformerFactory;
    }

    public void setTypeReferenceTransformerFactory(TypeReferenceTransformerFactory<Map<String, Object>> typeReferenceTransformerFactory) {
        this.typeReferenceTransformerFactory = typeReferenceTransformerFactory;
    }

}
