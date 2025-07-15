package algo.fun.algofun_prep.threemonth.week12.prim;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int n, List<List<Integer>> edges, int start, final int expectedResult) {
        //when
        final int result = Result.prims(n, edges, start);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        3, List.of(
                                List.of(1, 2, 2),
                                List.of(2, 3, 2),
                                List.of(1, 3, 3)
                        ), 1, 4
                ), Arguments.of(
                        5, List.of(
                                List.of(1, 2, 3),
                                List.of(1, 3, 4),
                                List.of(4, 2, 6),
                                List.of(5, 2, 2),
                                List.of(2, 3, 5),
                                List.of(3, 5, 7)
                        ), 1, 15
                )
        );
    }

}
