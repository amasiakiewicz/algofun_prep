package algo.fun.algofun_week1.day6.jesse;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(final int k, final List<Integer> A, final int expectedResult) {
        //when
        final int result = Result.cookies(k, A);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        7, List.of(1, 2, 3, 9, 10, 12), 2
                ),
                Arguments.of(
                        7, List.of(1, 2, 3, 5, 9, 10, 12), 3
                )
        );
    }

}
