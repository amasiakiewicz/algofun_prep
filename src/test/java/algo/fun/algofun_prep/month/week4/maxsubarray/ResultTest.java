package algo.fun.algofun_prep.month.week4.maxsubarray;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> arr, final List<Integer> expectedResult) {
        //when
        final List<Integer> result = Result.maxSubarray(arr);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 4), List.of(10, 10)
                ), Arguments.of(
                        List.of(-2, -3, -1, -4, -6), List.of(-1, -1)
                ), Arguments.of(
                        List.of(-1, 2, 3, -4, 5, 10), List.of(16, 20)
                ), Arguments.of(
                        List.of(-1, 2, 3, -8, 5, 10), List.of(15, 20)
                ), Arguments.of(
                        List.of(2, -1, 2, 3, 4, -5), List.of(10, 11)
                )
        );
    }

}
