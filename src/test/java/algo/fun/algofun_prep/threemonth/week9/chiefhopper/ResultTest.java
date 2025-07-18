package algo.fun.algofun_prep.threemonth.week9.chiefhopper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> arr, final long expectedResult) {
        //when
        final long result = Result.chiefHopper(arr);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(4), 2
                ), Arguments.of(
                        List.of(2, 3, 4, 3, 2), 3
                ), Arguments.of(
                        List.of(3, 4, 3, 2, 4), 4
                ), Arguments.of(
                        List.of(4, 4, 4), 4
                )
        );
    }

}
