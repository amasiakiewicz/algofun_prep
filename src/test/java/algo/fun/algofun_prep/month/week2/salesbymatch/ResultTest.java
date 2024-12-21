package algo.fun.algofun_prep.month.week2.salesbymatch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(int n, List<Integer> ar, final int expectedResult) {
        //when
        final int result = Result.sockMerchant(n, ar);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        9, List.of(10, 20, 20, 10, 10, 30, 50, 10, 20), 3
                )
        );
    }

}