package algo.fun.algofun_prep.bonus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(
            final String start, final String end, final List<String> expectedResult
    ) {
        //when
        final List<String> result = Solution.getShortestChessKnightPath(start, end);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        "B1", "E3", List.of("B1", "C3", "D5", "E3")
                )
        );
    }
    
}