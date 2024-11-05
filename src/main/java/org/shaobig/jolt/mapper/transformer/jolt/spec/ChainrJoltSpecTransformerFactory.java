package org.shaobig.jolt.mapper.transformer.jolt.spec;

import com.bazaarvoice.jolt.Chainr;
import org.shaobig.jolt.mapper.transformer.typeReference.TypeReferenceTransformerFactory;

import java.util.Map;

public class ChainrJoltSpecTransformerFactory extends JoltSpecTransformerFactory<Object> {

    public ChainrJoltSpecTransformerFactory(Chainr chainr, TypeReferenceTransformerFactory<Map<String, Object>> typeReferenceTransformerFactory) {
        super(chainr, typeReferenceTransformerFactory);
    }

    @Override
    public JoltSpecTransformer<Object> getTransformer() {
        return new ChainrJoltSpecTransformer(getChainr(), getTypeReferenceTransformerFactory().getTransformer());
    }

}
