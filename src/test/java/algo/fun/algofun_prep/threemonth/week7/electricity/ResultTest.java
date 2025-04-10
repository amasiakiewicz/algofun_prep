package algo.fun.algofun_prep.threemonth.week7.electricity;

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
        final int result = Result.pylons(k, arr);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        3, List.of(0, 1, 0, 0, 0, 1, 1, 1, 1, 1), 3
                ), Arguments.of(
                        2, List.of(0, 1, 1, 1, 1, 0), 2
                )
        );
    }

}
