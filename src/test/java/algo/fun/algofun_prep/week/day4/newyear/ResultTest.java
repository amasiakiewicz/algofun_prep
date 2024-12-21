package algo.fun.algofun_prep.week.day4.newyear;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> q, final String expectedBribes) {
        //when
        final String bribes = Result.minimumBribesResult(q);

        //then
        assertThat(bribes).isEqualTo(expectedBribes);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(2, 1, 3, 4, 6, 5, 7, 10, 9, 8), "5"
                ),  
                Arguments.of(
                        List.of(2, 1, 5, 3, 4), "3"
                ),
                Arguments.of(
                        List.of(1, 2, 5, 3, 7, 8, 6, 4), "7"
                ),
                Arguments.of(
                        List.of(2, 5, 1, 3, 4), "Too chaotic"
                )
        );
    }

}
