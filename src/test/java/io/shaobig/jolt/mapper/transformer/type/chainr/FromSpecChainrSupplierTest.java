package io.shaobig.jolt.mapper.transformer.type.chainr;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import io.shaobig.jolt.mapper.transformer.exception.WrongSpecificationException;
import io.shaobig.jolt.mapper.transformer.type.chainr.specification.ChainrSpecificationSupplier;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FromSpecChainrSupplierTest {

    private ChainrSpecificationSupplier chainrSpecificationSupplier;
    private FromSpecChainrSupplier fromSpecChainrSupplier;

    @BeforeEach
    void init() {
        this.chainrSpecificationSupplier = Mockito.mock(ChainrSpecificationSupplier.class);
        this.fromSpecChainrSupplier = new FromSpecChainrSupplier(chainrSpecificationSupplier);
    }

    static Stream<Arguments> getWrongSpecificationExceptionSource() {
        return Stream.of(
                Arguments.of("/io/shaobig/jolt/mapper/transformer/type/chainr/source-wrong-chainr-specification-1.json"),
                Arguments.of("/io/shaobig/jolt/mapper/transformer/type/chainr/source-wrong-chainr-specification-2.json")
        );
    }

    @ParameterizedTest
    @MethodSource(value = "getWrongSpecificationExceptionSource")
    void getWrongSpecificationException(String sourcePath) {
        List<Object> sourceWrongSpecificationList = JsonUtils.classpathToList(sourcePath);
        Mockito.when(chainrSpecificationSupplier.get()).thenReturn(sourceWrongSpecificationList);

        assertThrows(WrongSpecificationException.class, () -> fromSpecChainrSupplier.get());
    }

    @Test
    void get() {
        List<Object> sourceSpecificationList = JsonUtils.classpathToList("/io/shaobig/jolt/mapper/transformer/type/chainr/source-chainr-specification.json");
        Mockito.when(chainrSpecificationSupplier.get()).thenReturn(sourceSpecificationList);

        Chainr actual = fromSpecChainrSupplier.get();

        Chainr expected = Chainr.fromSpec(JsonUtils.classpathToList("/io/shaobig/jolt/mapper/transformer/type/chainr/expected-chainr-specification.json"));
        assertThat(expected).usingRecursiveComparison().isEqualTo(actual);
    }

}
