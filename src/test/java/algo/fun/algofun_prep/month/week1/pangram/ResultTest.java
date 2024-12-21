package algo.fun.algofun_prep.month.week1.pangram;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(String s, final String expectedResult) {
        //when
        final String result = Result.pangrams(s);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        "We promptly judged antique ivory buckles for the next prize", "pangram"
                ), Arguments.of(
                   "We promptly judged antique ivory buckles for the prize", "not pangram"
                )
        );
    }

}
