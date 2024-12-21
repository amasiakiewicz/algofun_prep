package algo.fun.algofun_prep.week.day4.recursivesum;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(String n, int k, final int expectedSuperDigit) {
        //when
        final int superDigit = Result.superDigit(n, k);

        //then
        assertThat(superDigit).isEqualTo(expectedSuperDigit);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        "9875", 4, 8
                ),
                Arguments.of(
                        "1", 10000, 1
                ),
                Arguments.of(
                        "91", 1, 1
                )
        );
    }

}
