package algo.fun.algofun_prep.month.week4.arraymanipulation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int n, List<List<Integer>> queries, final long expectedResult) {
        //when
        final long result = Result.arrayManipulation(n, queries);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        5, List.of(
                                List.of(1, 2, 100),
                                List.of(2, 5, 100),
                                List.of(3, 4, 100)
                        ), 200L
                )
        );
    }

}
