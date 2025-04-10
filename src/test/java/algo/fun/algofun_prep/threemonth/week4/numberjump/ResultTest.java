package algo.fun.algofun_prep.threemonth.week4.numberjump;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int x1, int v1, int x2, int v2, final String expectedResult) {
        //when
        final String result = Result.kangaroo(x1, v1, x2, v2);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        2, 1, 2, 1, "YES"
                )
        );
    }

}
