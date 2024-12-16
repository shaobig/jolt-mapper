package io.shaobig.jolt.mapper.transformer.type.chainr.specification;

import com.bazaarvoice.jolt.JsonUtils;

import java.util.List;
import java.util.function.Supplier;

public class StringChainrSpecificationSupplier extends ChainrSpecificationSupplier<String> {

    public StringChainrSpecificationSupplier(Supplier<String> pathSupplier) {
        super(pathSupplier);
    }

    @Override
    public List<Object> get() {
        return JsonUtils.classpathToList(getPathSupplier().get());
    }

}
