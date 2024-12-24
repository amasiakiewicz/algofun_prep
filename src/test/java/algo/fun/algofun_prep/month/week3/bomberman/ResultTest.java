package algo.fun.algofun_prep.month.week3.bomberman;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int n, List<String> grid, final List<String> expectedResults) {
        //when
        final List<String> results = Result.bomberMan(n, grid);

        //then
        assertThat(results).isEqualTo(expectedResults);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        3, List.of(
                                ".......", "...O...", "....O..", ".......", "OO.....", "OO....."
                        ), List.of(
                                "OOO.OOO", "OO...OO", "OOO...O", "..OO.OO", "...OOOO", "...OOOO"
                        )
                ),
                Arguments.of(5, List.of(".......", "...O.O.", "....O..", "..O....", "OO...OO",
                                "OO.O..."
                        ), List.of(".......", "...O.O.", "...OO..", "..OOOO.", "OOOOOOO",
                                "OOOOOOO"
                        )
                )

        );
    }

}
