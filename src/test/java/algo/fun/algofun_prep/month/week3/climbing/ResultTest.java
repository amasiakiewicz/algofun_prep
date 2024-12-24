package algo.fun.algofun_prep.month.week3.climbing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> ranked, List<Integer> player, final List<Integer> expectedResult) {
        //when
        final List<Integer> result = Result.climbingLeaderboard(ranked, player);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(100, 100, 50, 40, 40, 20, 10),
                        List.of(5, 25, 50, 120), List.of(6, 4, 2, 1)
                ), Arguments.of(
                        List.of(100, 90, 90, 80, 75, 60),
                        List.of(50, 65, 77, 90, 102), List.of(6, 5, 4, 2, 1)
                )
        );
    }

}
