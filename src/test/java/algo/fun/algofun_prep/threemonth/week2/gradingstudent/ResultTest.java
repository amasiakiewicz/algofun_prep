package algo.fun.algofun_prep.threemonth.week2.gradingstudent;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<Integer> grades, final List<Integer> expectedResult) {
        //when
        final List<Integer> result = Result.gradingStudents(grades);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(84, 29, 57), List.of(85, 29, 57)
                )
        );
    }

}
