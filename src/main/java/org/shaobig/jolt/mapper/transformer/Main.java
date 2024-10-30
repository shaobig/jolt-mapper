package org.shaobig.jolt.mapper.transformer;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.shaobig.jolt.mapper.transformer.entity.chainr.StringChainrSupplier;
import org.shaobig.jolt.mapper.transformer.entity.classType.ClassTypeTransformerFactory;
import org.shaobig.jolt.mapper.transformer.entity.classType.ObjectMapperClassTypeTransformerFactory;
import org.shaobig.jolt.mapper.transformer.entity.jolt.ClassTypeJoltTransformerFactory;
import org.shaobig.jolt.mapper.transformer.entity.jolt.JoltTransformer;
import org.shaobig.jolt.mapper.transformer.entity.jolt.spec.JoltSpecTransformerFactory;
import org.shaobig.jolt.mapper.transformer.entity.jolt.spec.MapStringObjectJoltSpecTransformerFactory;
import org.shaobig.jolt.mapper.transformer.entity.typeReference.ObjectMapperTypeReferenceTransformerFactory;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Chainr chainr = new StringChainrSupplier("/scratch.json").get();
        JoltSpecTransformerFactory<Object, Map<String, Object>> joltSpecTransformerFactory = new MapStringObjectJoltSpecTransformerFactory(chainr, new ObjectMapperTypeReferenceTransformerFactory<>(new TypeReference<>() {}));
        ClassTypeTransformerFactory<Object> classTypeTransformerFactory = new ObjectMapperClassTypeTransformerFactory<>(Object.class);
        JoltTransformer<Object> joltTransformer = new ClassTypeJoltTransformerFactory<>(joltSpecTransformerFactory, classTypeTransformerFactory).getTransformer();
        System.out.println(joltTransformer.transform(new RequestJson("ABC")));
    }

}
