package algo.fun.algofun_prep.threemonth.week1.sumpair;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int n, int k, List<Integer> ar, final int expectedResult) {
        //when
        final int result = Result.divisibleSumPairs(n, k, ar);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        6, 3, List.of(1, 3, 2, 6, 1, 2), 5
                )
        );
    }

}
