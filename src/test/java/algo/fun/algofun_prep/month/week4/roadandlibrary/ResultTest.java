package algo.fun.algofun_prep.month.week4.roadandlibrary;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int n, int c_lib, int c_road, List<List<Integer>> cities, final int expectedResult) {
        //when
        final long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        5, 6, 1, List.of(
                                List.of(1, 2), List.of(1, 3), List.of(1, 4)
                                ), 15
                ), Arguments.of(
                        3, 2, 1, List.of(
                                List.of(1, 2), List.of(3, 1), List.of(2, 3)
                        ), 4
                ), Arguments.of(
                        6, 2, 5, List.of(
                                List.of(1, 3), List.of(3, 4), List.of(2, 4),
                                List.of(1, 2), List.of(2, 3), List.of(5, 6)
                        ), 12
                )
        );
    }

}
