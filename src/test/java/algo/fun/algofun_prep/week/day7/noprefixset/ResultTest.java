package algo.fun.algofun_prep.week.day7.noprefixset;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(final List<String> words, final List<String> expectedResults) {
        //when
        final List<String> results = Result.noPrefixStr(words);

        //then
        assertThat(results).isEqualTo(expectedResults);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of("aab", "defgab", "abcde", "aabcde", "bbbbbbbbbb", "jabjjjad"),
                        List.of("BAD SET", "aabcde")
                ),Arguments.of(
                        List.of("abcd", "bcd", "abcde", "bcde"),
                        List.of("BAD SET", "abcde")
                ),Arguments.of(
                        List.of("ab", "bc", "cd"),
                        List.of("GOOD SET")
                ),Arguments.of(
                        List.of("aab", "aac", "aacghgh", "aabghgh"),
                        List.of("BAD SET", "aacghgh")
                )
        );
    }

}
