package algo.fun.algofun_prep.month.week3.sherlockstring;

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
        final String result = Result.isValid(s);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of("aabbcd", "NO"),
                Arguments.of("abcdefghhgfedecba", "YES")
        );
    }

}
