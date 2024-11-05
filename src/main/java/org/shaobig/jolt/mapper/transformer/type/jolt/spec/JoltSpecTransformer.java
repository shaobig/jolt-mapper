package org.shaobig.jolt.mapper.transformer.type.jolt.spec;

import com.bazaarvoice.jolt.Chainr;
import org.shaobig.jolt.mapper.transformer.Transformer;
import org.shaobig.jolt.mapper.transformer.type.typeReference.TypeReferenceTransformer;

import java.util.Map;

public abstract class JoltSpecTransformer<T> implements Transformer<T> {

    private Chainr chainr;
    private TypeReferenceTransformer<Map<String, Object>> typeReferenceTransformer;

    public JoltSpecTransformer(Chainr chainr, TypeReferenceTransformer<Map<String, Object>> typeReferenceTransformer) {
        this.chainr = chainr;
        this.typeReferenceTransformer = typeReferenceTransformer;
    }

    public Chainr getChainr() {
        return chainr;
    }

    public void setChainr(Chainr chainr) {
        this.chainr = chainr;
    }

    public TypeReferenceTransformer<Map<String, Object>> getTypeReferenceTransformer() {
        return typeReferenceTransformer;
    }

    public void setTypeReferenceTransformer(TypeReferenceTransformer<Map<String, Object>> typeReferenceTransformer) {
        this.typeReferenceTransformer = typeReferenceTransformer;
    }

}
