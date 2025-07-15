package algo.fun.algofun_prep.threemonth.week11.commonchild;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(String s1, String s2, final int expectedResult) {
        //when
        final int result = Result.commonChild(s1, s2);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        "WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS", "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC", 15
                ), Arguments.of(
                        "ABCD", "ABDC", 3
                ), Arguments.of(
                        "HARRY", "SALLY", 2
                ), Arguments.of(
                        "AA", "BB", 0
                ), Arguments.of(
                        "SHINCHAN", "NOHARAAA", 3
                ), Arguments.of(
                        "ABCDEF", "FBDAMN", 2
                )
        );
    }

}
