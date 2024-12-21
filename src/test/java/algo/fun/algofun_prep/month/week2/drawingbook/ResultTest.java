package algo.fun.algofun_prep.month.week2.drawingbook;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int n, int p, final int expectedResult) {
        //when
        final int result = Result.pageCount(n, p);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(5, 3, 1),
                Arguments.of(6, 5, 1),
                Arguments.of(6, 4, 1),
                Arguments.of(5, 4, 0),
                Arguments.of(5, 5, 0),
                Arguments.of(6, 6, 0)
        );
    }

}
