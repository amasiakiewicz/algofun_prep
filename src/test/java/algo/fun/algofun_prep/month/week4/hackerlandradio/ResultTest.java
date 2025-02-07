package algo.fun.algofun_prep.month.week4.hackerlandradio;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> x, int k, final int expectedResult) {
        //when
        final int result = Result.hackerlandRadioTransmitters(x, k);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 5, 9), 1, 3
                ), Arguments.of(
                        List.of(7, 2, 4, 6, 5, 9, 12, 11), 2, 3
                ), Arguments.of(
                        List.of(1, 2, 3, 4, 5), 1, 2
                )
        );
    }

}
