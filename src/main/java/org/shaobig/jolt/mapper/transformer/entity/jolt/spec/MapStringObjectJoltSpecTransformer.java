package org.shaobig.jolt.mapper.transformer.entity.jolt.spec;

import com.bazaarvoice.jolt.Chainr;
import org.shaobig.jolt.mapper.transformer.entity.typeReference.TypeReferenceTransformer;

import java.util.Map;

public class MapStringObjectJoltSpecTransformer extends JoltSpecTransformer<Object, Map<String, Object>> {

    public MapStringObjectJoltSpecTransformer(Chainr chainr, TypeReferenceTransformer<Map<String, Object>> typeReferenceTransformer) {
        super(chainr, typeReferenceTransformer);
    }

    @Override
    public Object transform(Object input) {
        return getChainr().transform(getTypeReferenceTransformer().transform(input));
    }

}
