package org.shaobig.jolt.mapper.facade;

import com.fasterxml.jackson.core.type.TypeReference;
import org.shaobig.jolt.mapper.transformer.chainr.FromSpecChainrSupplier;
import org.shaobig.jolt.mapper.transformer.chainr.specification.StringChainrSpecificationSupplier;
import org.shaobig.jolt.mapper.transformer.classType.ObjectMapperClassTypeTransformerFactory;
import org.shaobig.jolt.mapper.transformer.jolt.ClassTypeJoltTransformerFactory;
import org.shaobig.jolt.mapper.transformer.jolt.JoltTransformer;
import org.shaobig.jolt.mapper.transformer.jolt.spec.ChainrJoltSpecTransformerFactory;
import org.shaobig.jolt.mapper.transformer.jolt.spec.JoltSpecTransformerFactory;
import org.shaobig.jolt.mapper.transformer.typeReference.ObjectMapperTypeReferenceTransformerFactory;
import org.shaobig.jolt.mapper.transformer.typeReference.TypeReferenceTransformerFactory;

import java.util.Map;

public class FacadeJoltTransformerSupplier<T> extends JoltTransformerSupplier<T> {

    public FacadeJoltTransformerSupplier(String path, Class<T> classType) {
        super(path, classType);
    }

    @Override
    public JoltTransformer<T> get() {
        TypeReferenceTransformerFactory<Map<String, Object>> typeReferenceTransformerFactory = new ObjectMapperTypeReferenceTransformerFactory<>(new TypeReference<>() {});
        JoltSpecTransformerFactory<Object> joltSpecTransformerFactory = new ChainrJoltSpecTransformerFactory(new FromSpecChainrSupplier(new StringChainrSpecificationSupplier(this::getPath)).get(), typeReferenceTransformerFactory);
        return new ClassTypeJoltTransformerFactory<>(joltSpecTransformerFactory, new ObjectMapperClassTypeTransformerFactory<>(getClassType())).getTransformer();
    }

}
