package algo.fun.algofun_prep.week.day2.diagonaldiff;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<List<Integer>> arr, final int expectedDiff) {
        //when
        final int diagonalDifference = Result.diagonalDifference(arr);

        //then
        assertThat(diagonalDifference).isEqualTo(expectedDiff);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of(11, 2, 4),
                                List.of(4, 5, 6),
                                List.of(10, 8, -12)
                        ), 15
                ),
                Arguments.of(
                        List.of(
                                List.of(11, 2, 4, 5),
                                List.of(4, 5, 6, 8),
                                List.of(10, 8, -12, -3),
                                List.of(8, 7, 3, 4)
                        ), 19
                ),
                Arguments.of(
                        List.of(
                                List.of(1, 2, 3),
                                List.of(4, 5, 6),
                                List.of(9, 8, 9)
                        ), 2
                )
        );
    }

}
