package algo.fun.algofun_prep.threemonth.week5.missingnumber;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> arr, List<Integer> brr, final List<Integer> expectedResult) {
        //when
        final List<Integer> result = Result.missingNumbers(arr, brr);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(203, 204, 205, 206, 207, 208, 203, 204, 205, 206),
                        List.of(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204),
                        List.of(204, 205, 206)
                )
        );
    }

}
