package algo.fun.algofun_week1.day7.tree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(final Node root, final String expectedResult) {
        //when
        final String result = Solution.preOrderStr(root);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        head1(), "1 2 5 3 4 6"
                )
        );
    }

    private static Node head1() {
        Node root = null;
        root = Solution.insert(root, 1);
        root = Solution.insert(root, 2);
        root = Solution.insert(root, 5);
        root = Solution.insert(root, 6);
        root = Solution.insert(root, 3);
        root = Solution.insert(root, 4);

        return root;
    }

}
