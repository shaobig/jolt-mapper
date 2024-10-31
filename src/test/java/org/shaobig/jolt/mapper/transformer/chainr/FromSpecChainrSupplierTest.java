package org.shaobig.jolt.mapper.transformer.chainr;

import com.bazaarvoice.jolt.JsonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.shaobig.jolt.mapper.exception.WrongSpecificationException;
import org.shaobig.jolt.mapper.transformer.chainr.specification.ChainrSpecificationSupplier;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FromSpecChainrSupplierTest {

    private ChainrSpecificationSupplier<String> chainrSpecificationSupplier;
    private FromSpecChainrSupplier fromSpecChainrSupplier;

    @BeforeEach
    void init() {
        this.chainrSpecificationSupplier = Mockito.mock(ChainrSpecificationSupplier.class);
        this.fromSpecChainrSupplier = new FromSpecChainrSupplier(chainrSpecificationSupplier);
    }

    static Stream<Arguments> getWrongSpecificationExceptionSource() {
        return Stream.of(
                Arguments.of("/org/shaobig/jolt/mapper/transformer/chainr/source-wrong-chainr-specification-1.json"),
                Arguments.of("/org/shaobig/jolt/mapper/transformer/chainr/source-wrong-chainr-specification-2.json")
        );
    }

    @ParameterizedTest
    @MethodSource(value = "getWrongSpecificationExceptionSource")
    void getWrongSpecificationException(String sourcePath) {
        List<Object> sourceBadSpecificationList = JsonUtils.classpathToList(sourcePath);
        Mockito.when(chainrSpecificationSupplier.get()).thenReturn(sourceBadSpecificationList);

        assertThrows(WrongSpecificationException.class, () -> fromSpecChainrSupplier.get());
    }

}
