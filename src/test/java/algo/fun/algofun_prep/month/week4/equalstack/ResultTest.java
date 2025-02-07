package algo.fun.algofun_prep.month.week4.equalstack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> h1, List<Integer> h2, List<Integer> h3, final int expectedResult) {
        //when
        final int result = Result.equalStacks(h1, h2, h3);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(3, 2, 1, 1, 1), List.of(4, 3, 2),
                        List.of(1, 1, 4, 1), 5
                )
        );
    }

}
