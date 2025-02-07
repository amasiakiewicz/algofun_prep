package algo.fun.algofun_prep.month.week4.castlegrid;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<String> grid, int startX, int startY, int goalX, int goalY, final int expectedResult) {
        //when
        final int result = Result.minimumMoves(grid, startX, startY, goalX, goalY);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(".X.",".X.", "..."), 0, 0, 0, 2, 3
                )
        );
    }

}
