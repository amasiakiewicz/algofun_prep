package algo.fun.algofun_prep.week.day5.balancedbracket;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(String s, final String expectedAnswer) {
        //when
        final String answer = Result.isBalanced(s);

        //then
        assertThat(answer).isEqualTo(expectedAnswer);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        "{[()]}", "YES"
                ),
                Arguments.of(
                        "{[(])}", "NO"
                ),
                Arguments.of(
                        "{{[[(())]]}}", "YES"
                )
        );
    }

}
