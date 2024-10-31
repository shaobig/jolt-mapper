package org.shaobig.jolt.mapper.facade;

import org.shaobig.jolt.mapper.transformer.jolt.JoltTransformer;

import java.util.function.Supplier;

public abstract class JoltTransformerSupplier<T> implements Supplier<JoltTransformer<T>> {

    private String path;
    private Class<T> classType;

    public JoltTransformerSupplier(String path, Class<T> classType) {
        this.path = path;
        this.classType = classType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Class<T> getClassType() {
        return classType;
    }

    public void setClassType(Class<T> classType) {
        this.classType = classType;
    }

}
