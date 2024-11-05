package org.shaobig.jolt.mapper.transformer.type.chainr;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.shaobig.jolt.mapper.transformer.exception.EmptySpecificationException;
import org.shaobig.jolt.mapper.transformer.type.chainr.ChainrSupplier;
import org.shaobig.jolt.mapper.transformer.type.chainr.EmptySpecificationHandlerChainrSupplier;
import org.shaobig.jolt.mapper.transformer.type.chainr.specification.ChainrSpecificationSupplier;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmptySpecificationHandlerChainrSupplierTest {

    private ChainrSpecificationSupplier<String> chainrSpecificationSupplier;
    private ChainrSupplier chainrSupplier;
    private EmptySpecificationHandlerChainrSupplier emptySpecificationHandlerChainrSupplier;

    @BeforeEach
    void init() {
        this.chainrSpecificationSupplier = Mockito.mock(ChainrSpecificationSupplier.class);
        this.chainrSupplier = Mockito.mock(ChainrSupplier.class);
        this.emptySpecificationHandlerChainrSupplier = new EmptySpecificationHandlerChainrSupplier(chainrSpecificationSupplier, chainrSupplier);
    }

    @Test
    void getEmptySpecificationList() {
        Mockito.when(chainrSpecificationSupplier.get()).thenReturn(List.of());

        assertThrows(EmptySpecificationException.class, () -> emptySpecificationHandlerChainrSupplier.get());
    }

    @Test
    void get() {
        List<Object> sourceSpecificationList = List.of(new Object());
        Chainr sourceChainr = Chainr.fromSpec(JsonUtils.classpathToList("/org/shaobig/jolt/mapper/transformer/chainr/source-chainr-specification.json"));
        Mockito.when(chainrSpecificationSupplier.get()).thenReturn(sourceSpecificationList);
        Mockito.when(chainrSupplier.get()).thenReturn(sourceChainr);

        Chainr actual = emptySpecificationHandlerChainrSupplier.get();

        Chainr expected = Chainr.fromSpec(JsonUtils.classpathToList("/org/shaobig/jolt/mapper/transformer/chainr/expected-chainr-specification.json"));
        assertThat(expected).usingRecursiveComparison().isEqualTo(actual);
    }

}
