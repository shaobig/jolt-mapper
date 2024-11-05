package org.shaobig.jolt.mapper.transformer.type.chainr;

import com.bazaarvoice.jolt.Chainr;
import org.shaobig.jolt.mapper.transformer.type.chainr.specification.ChainrSpecificationSupplier;

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

}
