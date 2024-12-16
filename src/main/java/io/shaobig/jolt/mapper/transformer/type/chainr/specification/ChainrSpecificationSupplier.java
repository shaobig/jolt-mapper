package io.shaobig.jolt.mapper.transformer.type.chainr.specification;

import java.util.List;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChainrSpecificationSupplier<?> that = (ChainrSpecificationSupplier<?>) o;
        return Objects.equals(pathSupplier.get(), that.pathSupplier.get());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pathSupplier);
    }

}
