package org.shaobig.jolt.mapper.transformer.type.chainr.specification;

import java.util.List;
import java.util.function.Supplier;

public abstract class ChainrSpecificationSupplier<T> implements Supplier<List<Object>> {

    private Supplier<T> pathSupplier;

    public ChainrSpecificationSupplier(Supplier<T> pathSupplier) {
        this.pathSupplier = pathSupplier;
    }

    public Supplier<T> getPathSupplier() {
        return pathSupplier;
    }

    public void setPathSupplier(Supplier<T> pathSupplier) {
        this.pathSupplier = pathSupplier;
    }

}
