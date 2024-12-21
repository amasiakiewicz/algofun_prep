package algo.fun.algofun_prep.month.week2.sumxor;

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
        final long result = Result.sumXor(n);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 1),
                Arguments.of(4, 4),
                Arguments.of(5, 2),
                Arguments.of(6, 2),
                Arguments.of(7, 1),
                Arguments.of(8, 8),
                Arguments.of(9, 4),
                Arguments.of(10, 4),
                Arguments.of(11, 2),
                Arguments.of(12, 4),
                Arguments.of(13, 2),
                Arguments.of(14, 2),
                Arguments.of(15, 1),
                Arguments.of(16, 16),
                Arguments.of(1000000000000000L, 1073741824L)
        );
    }

}
