package algo.fun.algofun_prep.threemonth.week4.leftrotation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int d, List<Integer> arr, final List<Integer> expectedResult) {
        //when
        final List<Integer> result = Result.rotateLeft(d, arr);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        4, List.of(1, 2, 3, 4, 5), List.of(5, 1, 2, 3, 4)
                )
        );
    }

}
