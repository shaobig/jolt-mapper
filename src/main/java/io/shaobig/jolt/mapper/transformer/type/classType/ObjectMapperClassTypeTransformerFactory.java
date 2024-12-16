package io.shaobig.jolt.mapper.transformer.type.classType;

public class ObjectMapperClassTypeTransformerFactory<T> extends ClassTypeTransformerFactory<T> {

    public ObjectMapperClassTypeTransformerFactory(Class<T> classType) {
        super(classType);
    }

    @Override
    public ClassTypeTransformer<T> getTransformer() {
        return new ObjectMapperClassTypeTransformer<>(getClassType());
    }

}
