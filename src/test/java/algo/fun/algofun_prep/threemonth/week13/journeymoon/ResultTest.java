package algo.fun.algofun_prep.threemonth.week13.journeymoon;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int n, List<List<Integer>> astronaut, final long expectedResult) {
        //when
        final long result = Result.journeyToMoon(n, astronaut);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        4, List.of(
                                List.of(1, 2),
                                List.of(2, 3)
                        ), 3L
                )
        );
    }

}
