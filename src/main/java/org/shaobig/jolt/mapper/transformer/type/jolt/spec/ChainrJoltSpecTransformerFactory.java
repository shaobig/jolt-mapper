package org.shaobig.jolt.mapper.transformer.type.jolt.spec;

import org.shaobig.jolt.mapper.transformer.type.chainr.ChainrSupplier;
import org.shaobig.jolt.mapper.transformer.type.typeReference.TypeReferenceTransformerFactory;

import java.util.Map;

public class ChainrJoltSpecTransformerFactory extends JoltSpecTransformerFactory<Object> {

    public ChainrJoltSpecTransformerFactory(ChainrSupplier chainrSupplier, TypeReferenceTransformerFactory<Map<String, Object>> typeReferenceTransformerFactory) {
        super(chainrSupplier, typeReferenceTransformerFactory);
    }

    @Override
    public JoltSpecTransformer<Object> getTransformer() {
        return new ChainrJoltSpecTransformer(getChainrSupplier(), getTypeReferenceTransformerFactory().getTransformer());
    }

}
