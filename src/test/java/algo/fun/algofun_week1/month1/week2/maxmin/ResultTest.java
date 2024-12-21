package algo.fun.algofun_week1.month1.week2.maxmin;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int k, List<Integer> arr, final int expectedResult) {
        //when
        final int result = Result.maxMin(k, arr);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        4, List.of(1, 2, 3, 4, 10, 20, 30, 40, 100, 200), 3
                )
        );
    }

}
