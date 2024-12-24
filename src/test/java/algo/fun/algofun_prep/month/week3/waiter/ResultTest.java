package algo.fun.algofun_prep.month.week3.waiter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> number, int q, final List<Integer> expectedResult) {
        //when
        final List<Integer> result = Result.waiter(number, q);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(3, 4, 7, 6, 5), 1, 
                        List.of(4, 6, 3, 7, 5)
                ), 
                Arguments.of(
                        List.of(3, 3, 4, 4, 9), 2, 
                        List.of(4, 4, 9, 3, 3)
                ) 
        );
    }

}
