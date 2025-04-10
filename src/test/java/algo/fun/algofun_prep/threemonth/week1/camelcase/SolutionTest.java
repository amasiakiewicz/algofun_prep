package algo.fun.algofun_prep.threemonth.week1.camelcase;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(final String s, final String expectedResult) {
        //when
        final String result = Solution.createProcessedString(s);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of("S;M;plasticCup()", "plastic cup"),
                Arguments.of("C;V;mobile phone", "mobilePhone"),
                Arguments.of("C;C;coffee machine", "CoffeeMachine"),
                Arguments.of("S;C;LargeSoftwareBook", "large software book"),
                Arguments.of("C;M;white sheet of paper", "whiteSheetOfPaper()"),
                Arguments.of("S;V;pictureFrame", "picture frame")
        );
    }

}
