package org.shaobig.jolt.mapper.transformer.entity.chainr;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;

public class StringChainrSupplier extends ChainrSupplier<String> {

    public StringChainrSupplier(String path) {
        super(path);
    }

    @Override
    public Chainr get() {
        return Chainr.fromSpec(JsonUtils.classpathToList(getPath()));
    }

}
