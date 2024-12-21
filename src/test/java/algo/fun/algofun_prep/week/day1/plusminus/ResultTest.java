package algo.fun.algofun_prep.week.day1.plusminus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(final List<Integer> arr, final List<String> expectedResults) {
        //when
        final List<String> results = Result.plusMinusResult(arr);

        //then
        assertThat(results).isEqualTo(expectedResults);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(-4, 3, -9, 0, 4, 1),
                        List.of("0,500000", "0,333333", "0,166667")
                ),
                Arguments.of(
                        List.of(1, 1, 0, -1, -1),
                        List.of("0,400000", "0,400000", "0,200000")
                )
        );
    }

}
