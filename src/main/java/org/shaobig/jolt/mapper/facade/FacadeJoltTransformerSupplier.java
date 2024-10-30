package org.shaobig.jolt.mapper.facade;

import com.bazaarvoice.jolt.Chainr;
import com.fasterxml.jackson.core.type.TypeReference;
import org.shaobig.jolt.mapper.transformer.entity.chainr.StringChainrSupplier;
import org.shaobig.jolt.mapper.transformer.entity.classType.ClassTypeTransformerFactory;
import org.shaobig.jolt.mapper.transformer.entity.classType.ObjectMapperClassTypeTransformerFactory;
import org.shaobig.jolt.mapper.transformer.entity.jolt.ClassTypeJoltTransformerFactory;
import org.shaobig.jolt.mapper.transformer.entity.jolt.JoltTransformer;
import org.shaobig.jolt.mapper.transformer.entity.jolt.spec.JoltSpecTransformerFactory;
import org.shaobig.jolt.mapper.transformer.entity.jolt.spec.MapStringObjectJoltSpecTransformerFactory;
import org.shaobig.jolt.mapper.transformer.entity.typeReference.ObjectMapperTypeReferenceTransformerFactory;
import org.shaobig.jolt.mapper.transformer.entity.typeReference.TypeReferenceTransformerFactory;

import java.util.Map;

public class FacadeJoltTransformerSupplier<T> extends JoltTransformerSupplier<T> {

    public FacadeJoltTransformerSupplier(String path, Class<T> classType) {
        super(path, classType);
    }

    @Override
    public JoltTransformer<T> get() {
        TypeReferenceTransformerFactory<Map<String, Object>> typeReferenceTransformerFactory = new ObjectMapperTypeReferenceTransformerFactory<>(new TypeReference<>() {});
        JoltSpecTransformerFactory<Object, Map<String, Object>> joltSpecTransformerFactory = new MapStringObjectJoltSpecTransformerFactory(new StringChainrSupplier(getPath()).get(), typeReferenceTransformerFactory);
        return new ClassTypeJoltTransformerFactory<>(joltSpecTransformerFactory, new ObjectMapperClassTypeTransformerFactory<>(getClassType())).getTransformer();
    }

}
