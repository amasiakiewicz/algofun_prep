package algo.fun.algofun_prep.month.week4.lowestancestor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(final Node root, int v1, int v2, final Node expectedResult) {
        //when
        final Node result = Solution.lca(root, v1, v2);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        final Node root = root();
        return Stream.of(
                Arguments.of(
                        root,  1, 7, root
                )
        );
    }

    private static Node root() {
        final Node root = new Node(4);
        Solution.insert(root, 2);
        Solution.insert(root, 3);
        Solution.insert(root, 1);
        Solution.insert(root, 7);
        Solution.insert(root, 6);
        
        return root;
    }

}
