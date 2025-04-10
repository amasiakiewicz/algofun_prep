package algo.fun.algofun_prep.threemonth.week4.closestnumber;

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
        final List<Integer> result = Result.closestNumbers(arr);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(-20, -3916237, -357920, -3620601, 7374819, 
                                -7330761, 30, 6246457, -6461594, 266854), List.of(-20, 30)
                ), Arguments.of(
                        List.of(-20, -3916237, -357920, -3620601, 7374819, -7330761, 30,
                                6246457, -6461594, 266854, -520, -470), List.of(-520, -470, -20, 30)
                ), Arguments.of(
                        List.of(5, 4, 3, 2), List.of(2, 3, 3, 4, 4, 5)
                )
        );
    }

}
