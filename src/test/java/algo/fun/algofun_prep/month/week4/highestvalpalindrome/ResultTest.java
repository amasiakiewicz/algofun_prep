package algo.fun.algofun_prep.month.week4.highestvalpalindrome;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(String s, int n, int k, final String expectedResult) {
        //when
        final String result = Result.highestValuePalindrome(s, n, k);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        "932239", 6, 2, "992299"
                ), Arguments.of(
                        "1231", 4, 3, "9339"
                ), Arguments.of(
                        "12321", 5, 1, "12921"
                ), Arguments.of(
                        "3943", 4, 1, "3993"
                ), Arguments.of(
                        "092282", 6, 3, "992299"
                ), Arguments.of(
                        "0011", 4, 1, "-1"
                )
        );
    }

}
