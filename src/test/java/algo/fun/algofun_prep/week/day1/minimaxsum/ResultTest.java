package algo.fun.algofun_prep.week.day1.minimaxsum;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(final List<Integer> arr, final List<Long> expectedResults) {
        //when
        final List<Long> results = Result.miniMaxSumResult(arr);

        //then
        assertThat(results).isEqualTo(expectedResults);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 4, 5),
                        List.of(10L, 14L)
                ),
                Arguments.of(
                        List.of(1, 3, 5, 7, 9),
                        List.of(16L, 24L)
                )
        );
    }

}
