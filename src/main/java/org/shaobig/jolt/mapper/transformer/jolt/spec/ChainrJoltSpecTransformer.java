package org.shaobig.jolt.mapper.transformer.jolt.spec;

import com.bazaarvoice.jolt.Chainr;
import org.shaobig.jolt.mapper.transformer.typeReference.TypeReferenceTransformer;

import java.util.Map;

public class ChainrJoltSpecTransformer extends JoltSpecTransformer<Object> {

    public ChainrJoltSpecTransformer(Chainr chainr, TypeReferenceTransformer<Map<String, Object>> typeReferenceTransformer) {
        super(chainr, typeReferenceTransformer);
    }

    @Override
    public Object transform(Object input) {
        return getChainr().transform(getTypeReferenceTransformer().transform(input));
    }

}
