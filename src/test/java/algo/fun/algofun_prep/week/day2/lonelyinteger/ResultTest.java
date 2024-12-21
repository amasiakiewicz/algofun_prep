package algo.fun.algofun_prep.week.day2.lonelyinteger;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> a, final int expectedInteger) {
        //when
        final int lonelyInteger = Result.lonelyinteger(a);

        //then
        assertThat(lonelyInteger).isEqualTo(expectedInteger);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 4, 3, 2, 1), 4)
        );
    }

}
