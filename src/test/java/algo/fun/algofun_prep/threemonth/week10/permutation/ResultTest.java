package algo.fun.algofun_prep.threemonth.week10.permutation;

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
        final String result = Result.permutationGame(arr);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(5, 3, 2, 1, 4), "Bob"
                ), Arguments.of(
                        List.of(4, 2, 3, 1), "Alice"
                ), Arguments.of(
                        List.of(1, 3, 2), "Alice"
                )
        );
    }

}
