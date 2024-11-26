package algo.fun.algofun_week1.day4.grid;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<String> grid, final String expectedAnswer) {
        //when
        final String cipheredString = Result.gridChallenge(grid);

        //then
        assertThat(cipheredString).isEqualTo(expectedAnswer);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of("ebacd", "fghij", "olmkn", "trpqs", "xywuv"),
                        "YES"
                )
        );
    }

}
