package algo.fun.algofun_prep.threemonth.week13.contact;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(List<List<String>> queries, final List<Integer> expectedResult) {
        //when
        final List<Integer> result = Result.contacts(queries);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of("add", "ed"),
                                List.of("add", "eddie"),
                                List.of("add", "edward"),
                                List.of("find", "ed"),
                                List.of("add", "edwina"),
                                List.of("find", "edw"),
                                List.of("find", "a")
                        ), List.of(3, 2, 0)
                )
        );
    }

}
