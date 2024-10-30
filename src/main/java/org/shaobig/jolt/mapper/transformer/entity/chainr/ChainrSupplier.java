package org.shaobig.jolt.mapper.transformer.entity.chainr;

import com.bazaarvoice.jolt.Chainr;

import java.util.function.Supplier;

public abstract class ChainrSupplier<T> implements Supplier<Chainr> {

    private T path;

    public ChainrSupplier(T path) {
        this.path = path;
    }

    public T getPath() {
        return path;
    }

    public void setPath(T path) {
        this.path = path;
    }

}
