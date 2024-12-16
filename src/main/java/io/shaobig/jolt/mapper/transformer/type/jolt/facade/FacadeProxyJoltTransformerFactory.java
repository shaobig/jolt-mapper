package io.shaobig.jolt.mapper.transformer.type.jolt.facade;

import com.fasterxml.jackson.core.type.TypeReference;
import io.shaobig.jolt.mapper.transformer.type.chainr.FromSpecChainrSupplier;
import io.shaobig.jolt.mapper.transformer.type.chainr.specification.StringChainrSpecificationSupplier;
import io.shaobig.jolt.mapper.transformer.type.classType.ObjectMapperClassTypeTransformerFactory;
import io.shaobig.jolt.mapper.transformer.type.jolt.ClassTypeJoltTransformerFactory;
import io.shaobig.jolt.mapper.transformer.type.jolt.JoltTransformer;
import io.shaobig.jolt.mapper.transformer.type.jolt.spec.ChainrJoltSpecTransformerFactory;
import io.shaobig.jolt.mapper.transformer.type.jolt.spec.JoltSpecTransformerFactory;
import io.shaobig.jolt.mapper.transformer.type.typeReference.ObjectMapperTypeReferenceTransformerFactory;
import io.shaobig.jolt.mapper.transformer.type.typeReference.TypeReferenceTransformerFactory;

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
