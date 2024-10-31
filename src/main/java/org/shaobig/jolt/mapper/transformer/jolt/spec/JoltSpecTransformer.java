package org.shaobig.jolt.mapper.transformer.jolt.spec;

import com.bazaarvoice.jolt.Chainr;
import org.shaobig.jolt.mapper.transformer.Transformer;
import org.shaobig.jolt.mapper.transformer.typeReference.TypeReferenceTransformer;

public abstract class JoltSpecTransformer<T, M> implements Transformer<T> {

    private Chainr chainr;
    private TypeReferenceTransformer<M> typeReferenceTransformer;

    public JoltSpecTransformer(Chainr chainr, TypeReferenceTransformer<M> typeReferenceTransformer) {
        this.chainr = chainr;
        this.typeReferenceTransformer = typeReferenceTransformer;
    }

    public Chainr getChainr() {
        return chainr;
    }

    public void setChainr(Chainr chainr) {
        this.chainr = chainr;
    }

    public TypeReferenceTransformer<M> getTypeReferenceTransformer() {
        return typeReferenceTransformer;
    }

    public void setTypeReferenceTransformer(TypeReferenceTransformer<M> typeReferenceTransformer) {
        this.typeReferenceTransformer = typeReferenceTransformer;
    }

}
