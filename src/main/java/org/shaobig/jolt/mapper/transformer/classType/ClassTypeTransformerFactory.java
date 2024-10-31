package org.shaobig.jolt.mapper.transformer.classType;

import org.shaobig.jolt.mapper.transformer.TransformerFactory;

public abstract class ClassTypeTransformerFactory<T> implements TransformerFactory<T, ClassTypeTransformer<T>> {

    private Class<T> classType;

    public ClassTypeTransformerFactory(Class<T> classType) {
        this.classType = classType;
    }

    public Class<T> getClassType() {
        return classType;
    }

    public void setClassType(Class<T> classType) {
        this.classType = classType;
    }

}
