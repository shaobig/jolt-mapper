package io.shaobig.jolt.mapper.transformer.type.chainr;

import com.bazaarvoice.jolt.Chainr;
import io.shaobig.jolt.mapper.transformer.type.chainr.specification.ChainrSpecificationSupplier;

import java.util.Objects;
import java.util.function.Supplier;

public abstract class ChainrSupplier implements Supplier<Chainr> {

    private ChainrSpecificationSupplier<String> chainrSpecificationSupplier;

    public ChainrSupplier(ChainrSpecificationSupplier<String> chainrSpecificationSupplier) {
        this.chainrSpecificationSupplier = chainrSpecificationSupplier;
    }

    public ChainrSpecificationSupplier<String> getChainrSpecificationSupplier() {
        return chainrSpecificationSupplier;
    }

    public void setChainrSpecificationSupplier(ChainrSpecificationSupplier<String> chainrSpecificationSupplier) {
        this.chainrSpecificationSupplier = chainrSpecificationSupplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChainrSupplier that = (ChainrSupplier) o;
        return Objects.equals(chainrSpecificationSupplier, that.chainrSpecificationSupplier);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(chainrSpecificationSupplier);
    }

}
