package org.shaobig.jolt.mapper.transformer.classType;

public class ObjectMapperClassTypeTransformerFactory<T> extends ClassTypeTransformerFactory<T> {

    public ObjectMapperClassTypeTransformerFactory(Class<T> classType) {
        super(classType);
    }

    @Override
    public ClassTypeTransformer<T> getTransformer() {
        return new ObjectMapperClassTypeTransformer<>(getClassType());
    }

}
