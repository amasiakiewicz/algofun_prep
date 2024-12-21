package algo.fun.algofun_week1.month1.week1.permutingarray;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int k, List<Integer> A, List<Integer> B, final String expectedResult) {
        //when
        final String result = Result.twoArrays(k, A, B);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        10, List.of(2, 1, 3), List.of(7, 8, 9), "YES"
                ), Arguments.of(
                        5, List.of(1, 2, 2, 1), List.of(3, 3, 3, 4), "NO"
                ), Arguments.of(
                        4, List.of(20, 1), List.of(1, 1), "NO"
                ), Arguments.of(
                        10, List.of(10000, 1, 1, 1), List.of(1, 1, 1, 1), "NO"
                )
        );
    }

}
