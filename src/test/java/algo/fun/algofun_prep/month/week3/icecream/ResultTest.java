package algo.fun.algofun_prep.month.week3.icecream;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int m, List<Integer> arr, final List<Integer> expectedResult) {
        //when
        final List<Integer> result = Result.icecreamParlor(m, arr);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        4, List.of(1, 4, 5, 3, 2), List.of(1, 4)
                ), Arguments.of(
                        4, List.of(2, 2, 4, 3), List.of(1, 2)
                )
        );
    }

}
