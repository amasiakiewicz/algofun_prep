package algo.fun.algofun_prep.threemonth.week10.uniformstring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(String s, List<Integer> queries, final List<String> expectedResult) {
        //when
        final List<String> result = Result.weightedUniformStrings(s, queries);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                       "abbcccdddd", List.of(1, 7, 5, 4, 15), 
                        List.of("Yes", "No", "No", "Yes", "No")
                )
        );
    }

}
