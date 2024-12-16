package io.shaobig.jolt.mapper.transformer.type.chainr;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.exception.SpecException;
import io.shaobig.jolt.mapper.transformer.exception.WrongSpecificationException;
import io.shaobig.jolt.mapper.transformer.type.chainr.specification.ChainrSpecificationSupplier;

public class FromSpecChainrSupplier extends ChainrSupplier {

    public FromSpecChainrSupplier(ChainrSpecificationSupplier<String> chainrSpecificationSupplier) {
        super(chainrSpecificationSupplier);
    }

    @Override
    public Chainr get() {
        try {
            return Chainr.fromSpec(getChainrSpecificationSupplier().get());
        }
        catch (SpecException e) {
            throw new WrongSpecificationException(e.getMessage());
        }
    }

}
