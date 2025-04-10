package algo.fun.algofun_prep.threemonth.week6.magicsquare;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<List<Integer>> s, final int expectedResult) {
        //when
        final int result = Result.formingMagicSquare(s);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of(4, 9, 2),
                                List.of(3, 5, 7),
                                List.of(8, 1, 5)
                        ), 1
                )
        );
    }

}
