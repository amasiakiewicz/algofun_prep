package algo.fun.algofun_prep.threemonth.week9.stockmax;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> prices, final long expectedResult) {
        //when
        final long result = Result.stockmax(prices);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(5, 3, 2), 0
                ), Arguments.of(
                        List.of(1, 2, 100), 197
                ), Arguments.of(
                        List.of(1, 3, 1, 2), 3
                )
        );
    }

}
