package algo.fun.algofun_week1.month1.week1.sparsearray;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<String> strings, List<String> queries, final List<Integer> expectedResults) {
        //when
        final List<Integer> results = Result.matchingStrings(strings, queries);

        //then
        assertThat(results).isEqualTo(expectedResults);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of("ab", "ab", "abc"),
                        List.of("ab", "abc", "bc"),
                        List.of(2, 1, 0)
                ), Arguments.of(
                        List.of("aba", "baba", "aba", "xzxb"),
                        List.of("aba", "xzxb", "ab"),
                        List.of(2, 1, 0)
                ), Arguments.of(
                        List.of("def", "de", "fgh"),
                        List.of("de", "lmn", "fgh"),
                        List.of(1, 0, 1)
                ), Arguments.of(
                        List.of("abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf",
                                "na", "asdjf", "na", "basdn", "sdaklfj", "asdjf"),
                        List.of("abcde", "sdaklfj", "asdjf", "na", "basdn"),
                        List.of(1, 3, 4, 3, 2)
                )
        );
    }

}
