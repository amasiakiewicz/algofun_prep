package algo.fun.algofun_prep.threemonth.week9.twochar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(String s, final long expectedResult) {
        //when
        final long result = Result.alternate(s);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        "asvkugfiugsalddlasguifgukvsa", 0
                ), Arguments.of(
                        "beabeefeab", 5
                )
        );
    }

}
