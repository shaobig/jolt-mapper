package org.shaobig.jolt.mapper.transformer.entity.classType;

import org.shaobig.jolt.mapper.transformer.entity.Transformer;

public abstract class ClassTypeTransformer<T> implements Transformer<T> {

    private Class<T> returnClass;

    public ClassTypeTransformer(Class<T> returnClass) {
        this.returnClass = returnClass;
    }

    public Class<T> getReturnClass() {
        return returnClass;
    }

    public void setReturnClass(Class<T> returnClass) {
        this.returnClass = returnClass;
    }

}
