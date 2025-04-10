package algo.fun.algofun_prep.threemonth.week3.maxperimiter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> sticks, final List<Integer> expectedResult) {
        //when
        final List<Integer> result = Result.maximumPerimeterTriangle(sticks);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 10), List.of(3, 4, 5)
                )
        );
    }

}
