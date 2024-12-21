package algo.fun.algofun_week1.month1.week2.dynamicarray;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int n, List<List<Integer>> queries, final List<Integer> expectedResults) {
        //when
        final List<Integer> results = Result.dynamicArray(n, queries);

        //then
        assertThat(results).isEqualTo(expectedResults);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        2, List.of(
                                List.of(1, 0, 5),
                                List.of(1, 1, 7),
                                List.of(1, 0, 3),
                                List.of(2, 1, 0),
                                List.of(2, 1, 1)
                        ), List.of(7, 3)
                )
        );
    }

}
