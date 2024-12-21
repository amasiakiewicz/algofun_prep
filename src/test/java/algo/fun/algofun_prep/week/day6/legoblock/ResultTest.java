package algo.fun.algofun_prep.week.day6.legoblock;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int n, int m, final int expectedResult) {
        //when
        final int result = Result.legoBlocks(n, m);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        2, 2, 3
                ), Arguments.of(
                        3, 2, 7
                ), Arguments.of(
                        2, 3, 9
                ), Arguments.of(
                        4, 4, 3375
                )
        );
    }

}
