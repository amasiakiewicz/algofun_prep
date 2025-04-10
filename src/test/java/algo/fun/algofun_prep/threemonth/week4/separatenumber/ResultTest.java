package algo.fun.algofun_prep.threemonth.week4.separatenumber;

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
        final String result = Result.createSeparateNumbers(s);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        "1234", "YES 1"
                ), Arguments.of(
                        "91011", "YES 9"
                ), Arguments.of(
                        "99100", "YES 99"
                ), Arguments.of(
                        "101103", "NO"
                ), Arguments.of(
                        "010203", "NO"
                ), Arguments.of(
                        "13", "NO"
                ), Arguments.of(
                        "1", "NO"
                ), Arguments.of(
                        "11111111111111111111111111111111", "NO"
                )
        );
    }

}
