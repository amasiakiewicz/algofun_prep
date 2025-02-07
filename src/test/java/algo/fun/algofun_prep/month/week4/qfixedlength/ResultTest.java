package algo.fun.algofun_prep.month.week4.qfixedlength;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> arr, List<Integer> queries, final List<Integer> expectedResult) {
        //when
        final List<Integer> result = Result.solve(arr, queries);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(33, 11, 44, 11, 55), List.of(1, 2, 3, 4, 5),
                        List.of(11, 33, 44, 44, 55)
                ), Arguments.of(
                        List.of(2, 3, 4, 5, 6), List.of(2, 3),
                        List.of(3, 4)
                ), Arguments.of(
                        List.of(1, 2, 3, 4, 5), List.of(1, 2, 3, 4, 5),
                        List.of(1, 2, 3, 4, 5)
                )
        );
    }

}
