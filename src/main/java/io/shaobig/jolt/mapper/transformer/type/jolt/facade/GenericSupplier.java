package io.shaobig.jolt.mapper.transformer.type.jolt.facade;

import java.util.Objects;
import java.util.function.Supplier;

public abstract class GenericSupplier<T> implements Supplier<T> {

    private T entity;

    public GenericSupplier(T entity) {
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericSupplier<?> that = (GenericSupplier<?>) o;
        return Objects.equals(entity, that.entity);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(entity);
    }

}
