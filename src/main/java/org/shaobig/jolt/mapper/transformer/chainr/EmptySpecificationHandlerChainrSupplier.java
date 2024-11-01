package org.shaobig.jolt.mapper.transformer.chainr;

import com.bazaarvoice.jolt.Chainr;
import org.shaobig.jolt.mapper.exception.EmptySpecificationException;
import org.shaobig.jolt.mapper.transformer.chainr.specification.ChainrSpecificationSupplier;

import java.util.List;

public class EmptySpecificationHandlerChainrSupplier extends ChainrSupplier {

    private ChainrSupplier chainrSupplier;

    public EmptySpecificationHandlerChainrSupplier(ChainrSpecificationSupplier<String> chainrSpecificationSupplier, ChainrSupplier chainrSupplier) {
        super(chainrSpecificationSupplier);
        this.chainrSupplier = chainrSupplier;
    }

    @Override
    public Chainr get() {
        List<Object> specificationList = getChainrSpecificationSupplier().get();
        if (specificationList.isEmpty()) {
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
