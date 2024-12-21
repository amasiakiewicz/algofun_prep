package algo.fun.algofun_week1.month1.week2.sherlock;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> arr, final String expectedResult) {
        //when
        final String result = Result.balancedSums(arr);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3), "NO"
                ), Arguments.of(
                        List.of(1, 2, 3, 3), "YES"
                ), Arguments.of(
                        List.of(1, 1, 4, 1, 1), "YES"
                ), Arguments.of(
                        List.of(2, 0, 0, 0), "YES"
                ), Arguments.of(
                        List.of(0, 0, 2, 0), "YES"
                )
        );
    }

}
