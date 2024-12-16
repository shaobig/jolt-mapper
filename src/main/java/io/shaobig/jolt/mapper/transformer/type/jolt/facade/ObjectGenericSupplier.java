package io.shaobig.jolt.mapper.transformer.type.jolt.facade;

public class ObjectGenericSupplier<T> extends GenericSupplier<T> {

    public ObjectGenericSupplier(T entity) {
        super(entity);
    }

    @Override
    public T get() {
        return getEntity();
    }

}
