package algo.fun.algofun_prep.threemonth.week13.runningmedian;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> a, final List<Double> expectedResult) {
        //when
        final List<Double> result = Result.runningMedian(a);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(7, 3, 5, 2), List.of(
                                Double.valueOf("7.0"), Double.valueOf("5.0"), Double.valueOf("5.0"),
                                Double.valueOf("4.0")
                        )
                )
        );
    }

}
