package algo.fun.algofun_week1.day1.timeconversion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(final String inputTime, final String expectedTime) {
        //when
        final String timeConverted = Result.timeConversion(inputTime);

        //then
        assertThat(timeConverted).isEqualTo(expectedTime);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of("07:05:45PM", "19:05:45"),
                Arguments.of("12:01:00PM", "12:01:00"),
                Arguments.of("12:01:00AM", "00:01:00")
        );
    }

}