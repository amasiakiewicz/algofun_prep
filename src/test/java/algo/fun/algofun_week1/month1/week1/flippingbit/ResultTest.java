package algo.fun.algofun_week1.month1.week1.flippingbit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(long n, final long expectedResult) {
        //when
        final long result = Result.flippingBits(n);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(2147483647L, 2147483648L),
                Arguments.of(1L, 4294967294L),
                Arguments.of(0L, 4294967295L)
        );
    }

}
