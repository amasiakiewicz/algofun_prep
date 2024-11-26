package algo.fun.algofun_week1.day3.caesarcipher;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(final String textToCipher, final int k, final String expectedCipheredStr) {
        //when
        final String cipheredString = Result.caesarCipher(textToCipher, k);

        //then
        assertThat(cipheredString).isEqualTo(expectedCipheredStr);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        "middle-Outz", 2, "okffng-Qwvb"
                )
        );
    }

}
