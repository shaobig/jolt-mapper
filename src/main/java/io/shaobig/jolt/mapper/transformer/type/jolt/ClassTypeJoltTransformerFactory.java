package io.shaobig.jolt.mapper.transformer.type.jolt;

import io.shaobig.jolt.mapper.transformer.type.classType.ClassTypeTransformerFactory;
import io.shaobig.jolt.mapper.transformer.type.jolt.spec.JoltSpecTransformerFactory;

public class ClassTypeJoltTransformerFactory<T> extends JoltTransformerFactory<T> {

    private ClassTypeTransformerFactory<T> classTypeTransformerFactory;

    public ClassTypeJoltTransformerFactory(JoltSpecTransformerFactory<Object> joltSpecTransformerFactory, ClassTypeTransformerFactory<T> classTypeTransformerFactory) {
        super(joltSpecTransformerFactory);
        this.classTypeTransformerFactory = classTypeTransformerFactory;
    }

    @Override
    public JoltTransformer<T> getTransformer() {
        return new ClassTypeJoltTransformer<>(getJoltSpecTransformerFactory().getTransformer(), getClassTypeTransformerFactory().getTransformer());
    }

    public ClassTypeTransformerFactory<T> getClassTypeTransformerFactory() {
        return classTypeTransformerFactory;
    }

    public void setClassTypeTransformerFactory(ClassTypeTransformerFactory<T> classTypeTransformerFactory) {
        this.classTypeTransformerFactory = classTypeTransformerFactory;
    }

}
