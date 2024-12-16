package io.shaobig.jolt.mapper.transformer.type.chainr;

import com.bazaarvoice.jolt.Chainr;
import io.shaobig.jolt.mapper.transformer.exception.EmptySpecificationException;
import io.shaobig.jolt.mapper.transformer.type.chainr.specification.ChainrSpecificationSupplier;

public class EmptySpecificationHandlerChainrSupplier extends ChainrSupplier {

    private ChainrSupplier chainrSupplier;

    public EmptySpecificationHandlerChainrSupplier(ChainrSpecificationSupplier<String> chainrSpecificationSupplier, ChainrSupplier chainrSupplier) {
        super(chainrSpecificationSupplier);
        this.chainrSupplier = chainrSupplier;
    }

    @Override
    public Chainr get() {
        if (getChainrSpecificationSupplier().get().isEmpty()) {
            throw new EmptySpecificationException("The JOLT specification should not be empty");
        }
        return getChainrSupplier().get();
    }

    public ChainrSupplier getChainrSupplier() {
        return chainrSupplier;
    }

    public void setChainrSupplier(ChainrSupplier chainrSupplier) {
        this.chainrSupplier = chainrSupplier;
    }

}
