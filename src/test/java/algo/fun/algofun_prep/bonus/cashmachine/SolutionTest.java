package algo.fun.algofun_prep.bonus.cashmachine;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int amountToPay, int amountGiven, final List<Integer> expectedResult) {
        //when
        final List<Integer> result = Solution.cashMachine(amountToPay, amountGiven);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        154, 200, List.of(20, 20, 5, 1)
                )
        );
    }

}