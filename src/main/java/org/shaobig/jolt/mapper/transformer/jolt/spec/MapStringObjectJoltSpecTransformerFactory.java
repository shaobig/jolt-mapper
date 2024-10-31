package org.shaobig.jolt.mapper.transformer.jolt.spec;

import com.bazaarvoice.jolt.Chainr;
import org.shaobig.jolt.mapper.transformer.typeReference.TypeReferenceTransformerFactory;

import java.util.Map;

public class MapStringObjectJoltSpecTransformerFactory extends JoltSpecTransformerFactory<Object, Map<String, Object>> {

    public MapStringObjectJoltSpecTransformerFactory(Chainr chainr, TypeReferenceTransformerFactory<Map<String, Object>> typeReferenceTransformerFactory) {
        super(chainr, typeReferenceTransformerFactory);
    }

    @Override
    public JoltSpecTransformer<Object, Map<String, Object>> getTransformer() {
        return new MapStringObjectJoltSpecTransformer(getChainr(), getTypeReferenceTransformerFactory().getTransformer());
    }

}
