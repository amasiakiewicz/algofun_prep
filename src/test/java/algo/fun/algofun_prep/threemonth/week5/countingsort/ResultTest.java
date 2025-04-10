package algo.fun.algofun_prep.threemonth.week5.countingsort;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<List<String>> arr, final String expectedResult) {
        //when
        final String result = Result.countSortStr(arr);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of("0", "ab"),
                                List.of("6", "cd"),
                                List.of("0", "ef"),
                                List.of("6", "gh"),
                                List.of("4", "ij"),
                                List.of("0", "ab"),
                                List.of("6", "cd"),
                                List.of("0", "ef"),
                                List.of("6", "gh"),
                                List.of("0", "ij"),
                                List.of("4", "that"),
                                List.of("3", "be"),
                                List.of("0", "to"),
                                List.of("1", "be"),
                                List.of("5", "question"),
                                List.of("1", "or"),
                                List.of("2", "not"),
                                List.of("4", "is"),
                                List.of("2", "to"),
                                List.of("4", "the")
                        ), "- - - - - to be or not to be - that is the question - - - -"
                )
        );
    }

}
