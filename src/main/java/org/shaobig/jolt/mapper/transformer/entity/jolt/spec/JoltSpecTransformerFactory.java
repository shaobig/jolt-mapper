package org.shaobig.jolt.mapper.transformer.entity.jolt.spec;

import com.bazaarvoice.jolt.Chainr;
import org.shaobig.jolt.mapper.transformer.entity.TransformerFactory;
import org.shaobig.jolt.mapper.transformer.entity.typeReference.TypeReferenceTransformerFactory;

public abstract class JoltSpecTransformerFactory<T, M> implements TransformerFactory<T, JoltSpecTransformer<T, M>> {

    private Chainr chainr;
    private TypeReferenceTransformerFactory<M> typeReferenceTransformerFactory;

    public JoltSpecTransformerFactory(Chainr chainr, TypeReferenceTransformerFactory<M> typeReferenceTransformerFactory) {
        this.chainr = chainr;
        this.typeReferenceTransformerFactory = typeReferenceTransformerFactory;
    }

    public Chainr getChainr() {
        return chainr;
    }

    public void setChainr(Chainr chainr) {
        this.chainr = chainr;
    }

    public TypeReferenceTransformerFactory<M> getTypeReferenceTransformerFactory() {
        return typeReferenceTransformerFactory;
    }

    public void setTypeReferenceTransformerFactory(TypeReferenceTransformerFactory<M> typeReferenceTransformerFactory) {
        this.typeReferenceTransformerFactory = typeReferenceTransformerFactory;
    }

}
