package algo.fun.algofun_prep.threemonth.week13.cubesum;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int n, List<String> operations, final List<Long> expectedResult) {
        //when
        final List<Long> result = Result.cubeSum(n, operations);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        4, List.of(
                                "UPDATE 2 2 2 4",
                                "QUERY 1 1 1 3 3 3",
                                "UPDATE 1 1 1 23",
                                "QUERY 2 2 2 4 4 4",
                                "QUERY 1 1 1 3 3 3"
                        ), List.of(4L, 4L, 27L)
                )
        );
    }

}
