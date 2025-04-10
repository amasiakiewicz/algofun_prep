package algo.fun.algofun_prep.threemonth.week5.sansaxor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> arr, final int expectedResult) {
        //when
        final int result = Result.sansaXor(arr);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                      List.of(1, 2, 3), 2  
                ), Arguments.of(
                      List.of(4, 5, 7, 5), 0  
                )
        );
    }

}
