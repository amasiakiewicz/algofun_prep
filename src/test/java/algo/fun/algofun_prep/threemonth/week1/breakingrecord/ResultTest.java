package algo.fun.algofun_prep.threemonth.week1.breakingrecord;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(final List<Integer> scores, final List<Integer> expectedResult) {
        //when
        final List<Integer> result = Result.breakingRecords(scores);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(12, 24, 10, 24), List.of(1, 1)
                )
        );
    }

}
