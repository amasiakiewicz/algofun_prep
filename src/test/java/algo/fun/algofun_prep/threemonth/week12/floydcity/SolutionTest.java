package algo.fun.algofun_prep.threemonth.week12.floydcity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(
            final int nodes, final List<Integer> roadFrom, final List<Integer> roadTo, final List<Integer> roadWeight,
            final List<Integer> xs, final List<Integer> ys, final List<Integer> expectedResult
    ) {
        //when
        final List<Integer> result = Solution.calculateDistances(nodes, roadFrom, roadTo, roadWeight, xs, ys);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        4, List.of(1, 1, 2, 3, 3), List.of(2, 4, 4, 4, 2),
                        List.of(5, 24, 6, 4, 7), List.of(1, 3, 1), List.of(2, 1, 4),
                        List.of(5, -1, 11)
                )
        );
    }

}
