package org.shaobig.jolt.mapper.transformer.type.jolt.facade;

import org.shaobig.jolt.mapper.transformer.TransformerFactory;
import org.shaobig.jolt.mapper.transformer.type.jolt.JoltTransformer;

import java.util.function.Supplier;

public abstract class ProxyJoltTransformerFactory<T> implements TransformerFactory<T, JoltTransformer<T>> {

    private Supplier<String> pathSupplier;
    private Supplier<Class<T>> classTypeSupplier;

    public ProxyJoltTransformerFactory(Supplier<String> pathSupplier, Supplier<Class<T>> classTypeSupplier) {
        this.pathSupplier = pathSupplier;
        this.classTypeSupplier = classTypeSupplier;
    }

    public Supplier<String> getPathSupplier() {
        return pathSupplier;
    }

    public void setPathSupplier(Supplier<String> pathSupplier) {
        this.pathSupplier = pathSupplier;
    }

    public Supplier<Class<T>> getClassTypeSupplier() {
        return classTypeSupplier;
    }

    public void setClassTypeSupplier(Supplier<Class<T>> classTypeSupplier) {
        this.classTypeSupplier = classTypeSupplier;
    }

}
