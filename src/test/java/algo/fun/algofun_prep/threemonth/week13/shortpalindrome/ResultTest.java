package algo.fun.algofun_prep.threemonth.week13.shortpalindrome;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(String s, final int expectedResult) {
        //when
        final int result = Result.shortPalindrome(s);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        "kkkkkkz", 15
                ), Arguments.of(
                        "ghhggh", 4
                )
        );
    }

}
