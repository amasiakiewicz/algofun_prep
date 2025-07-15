package algo.fun.algofun_prep.threemonth.week13.jack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight,
            final int expectedResult) {
        //when
        final int result = Result.getCostInt(gNodes, gFrom, gTo, gWeight);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        4, List.of(1, 1, 2, 3), List.of(2, 3, 4, 4),
                        List.of(20, 5, 30, 40), 30
                )
        );
    }

}
