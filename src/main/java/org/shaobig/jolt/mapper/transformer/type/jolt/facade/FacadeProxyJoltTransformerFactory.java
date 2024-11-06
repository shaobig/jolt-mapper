package org.shaobig.jolt.mapper.transformer.type.jolt.facade;

import com.fasterxml.jackson.core.type.TypeReference;
import org.shaobig.jolt.mapper.transformer.type.chainr.FromSpecChainrSupplier;
import org.shaobig.jolt.mapper.transformer.type.chainr.specification.StringChainrSpecificationSupplier;
import org.shaobig.jolt.mapper.transformer.type.classType.ObjectMapperClassTypeTransformerFactory;
import org.shaobig.jolt.mapper.transformer.type.jolt.ClassTypeJoltTransformerFactory;
import org.shaobig.jolt.mapper.transformer.type.jolt.JoltTransformer;
import org.shaobig.jolt.mapper.transformer.type.jolt.spec.ChainrJoltSpecTransformerFactory;
import org.shaobig.jolt.mapper.transformer.type.jolt.spec.JoltSpecTransformerFactory;
import org.shaobig.jolt.mapper.transformer.type.typeReference.ObjectMapperTypeReferenceTransformerFactory;
import org.shaobig.jolt.mapper.transformer.type.typeReference.TypeReferenceTransformerFactory;

import java.util.Map;
import java.util.function.Supplier;

public class FacadeProxyJoltTransformerFactory<T> extends ProxyJoltTransformerFactory<T> {

    public FacadeProxyJoltTransformerFactory(Supplier<String> pathSupplier, Supplier<Class<T>> classTypeSupplier) {
        super(pathSupplier, classTypeSupplier);
    }

    @Override
    public JoltTransformer<T> getTransformer() {
        TypeReferenceTransformerFactory<Map<String, Object>> typeReferenceTransformerFactory = new ObjectMapperTypeReferenceTransformerFactory<>(new TypeReference<>() {});
        JoltSpecTransformerFactory<Object> joltSpecTransformerFactory = new ChainrJoltSpecTransformerFactory(new FromSpecChainrSupplier(new StringChainrSpecificationSupplier(getPathSupplier())), typeReferenceTransformerFactory);
        return new ClassTypeJoltTransformerFactory<>(joltSpecTransformerFactory, new ObjectMapperClassTypeTransformerFactory<>(getClassTypeSupplier().get())).getTransformer();

    }

}
