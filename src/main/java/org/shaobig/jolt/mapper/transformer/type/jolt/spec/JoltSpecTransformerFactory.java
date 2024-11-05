package org.shaobig.jolt.mapper.transformer.type.jolt.spec;

import com.bazaarvoice.jolt.Chainr;
import org.shaobig.jolt.mapper.transformer.TransformerFactory;
import org.shaobig.jolt.mapper.transformer.type.typeReference.TypeReferenceTransformerFactory;

import java.util.Map;

public abstract class JoltSpecTransformerFactory<T> implements TransformerFactory<T, JoltSpecTransformer<T>> {

    private Chainr chainr;
    private TypeReferenceTransformerFactory<Map<String, Object>> typeReferenceTransformerFactory;

    public JoltSpecTransformerFactory(Chainr chainr, TypeReferenceTransformerFactory<Map<String, Object>> typeReferenceTransformerFactory) {
        this.chainr = chainr;
        this.typeReferenceTransformerFactory = typeReferenceTransformerFactory;
    }

    public Chainr getChainr() {
        return chainr;
    }

    public void setChainr(Chainr chainr) {
        this.chainr = chainr;
    }

    public TypeReferenceTransformerFactory<Map<String, Object>> getTypeReferenceTransformerFactory() {
        return typeReferenceTransformerFactory;
    }

    public void setTypeReferenceTransformerFactory(TypeReferenceTransformerFactory<Map<String, Object>> typeReferenceTransformerFactory) {
        this.typeReferenceTransformerFactory = typeReferenceTransformerFactory;
    }

}
