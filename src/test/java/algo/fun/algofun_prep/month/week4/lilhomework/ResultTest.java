package algo.fun.algofun_prep.month.week4.lilhomework;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> arr, final int expectedResult) {
        //when
        final int result = Result.lilysHomework(arr);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(3, 4, 2, 5, 1), 2
                ), Arguments.of(
                        List.of(7, 15, 12, 3), 2
                ), Arguments.of(
                        List.of(2, 5, 3, 1), 2
                )
        );
    }

}
