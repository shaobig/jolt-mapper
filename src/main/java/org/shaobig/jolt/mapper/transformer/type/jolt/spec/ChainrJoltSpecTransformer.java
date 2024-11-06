package org.shaobig.jolt.mapper.transformer.type.jolt.spec;

import org.shaobig.jolt.mapper.transformer.type.chainr.ChainrSupplier;
import org.shaobig.jolt.mapper.transformer.type.typeReference.TypeReferenceTransformer;

import java.util.Map;

public class ChainrJoltSpecTransformer extends JoltSpecTransformer<Object> {

    public ChainrJoltSpecTransformer(ChainrSupplier chainrSupplier, TypeReferenceTransformer<Map<String, Object>> typeReferenceTransformer) {
        super(chainrSupplier, typeReferenceTransformer);
    }

    @Override
    public Object transform(Object input) {
        return getChainrSupplier().get().transform(getTypeReferenceTransformer().transform(input));
    }

}
