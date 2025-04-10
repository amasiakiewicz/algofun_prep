package algo.fun.algofun_prep.threemonth.week5.strongpassword;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int n, String password, final int expectedResult) {
        //when
        final int result = Result.minimumNumber(n, password);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        5, "2bbbb", 2
                ), Arguments.of(
                        5, "2bb#A", 1
                )
        );
    }

}
