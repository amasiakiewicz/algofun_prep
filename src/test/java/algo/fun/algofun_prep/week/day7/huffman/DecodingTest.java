package algo.fun.algofun_prep.week.day7.huffman;

import static algo.fun.algofun_prep.week.day7.huffman.Solution.buildTree;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DecodingTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(final String s, final Node root, final String expectedResult) {
        //given
        final Decoding d = new Decoding();
        
        //when
        final String result = d.decodeStr(s, root);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        "1001011", tree("ABACA"), "ABACA"
                )
        );
    }

    private static Node tree(String s) {
        int[] charFreqs = new int[256];

        for (char c : s.toCharArray())
            charFreqs[c]++;

        return buildTree(charFreqs);
    }

}