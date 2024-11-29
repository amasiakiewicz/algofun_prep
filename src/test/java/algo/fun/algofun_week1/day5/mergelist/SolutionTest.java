package algo.fun.algofun_week1.day5.mergelist;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("provideParamsForResult")
    void shouldResult(
            Solution.SinglyLinkedListNode head1, Solution.SinglyLinkedListNode head2,
            Solution.SinglyLinkedListNode expectedHead
    ) throws IOException {
        //when
        final Solution.SinglyLinkedListNode mergedLists = Solution.mergeLists(head1, head2);

        //then
        assertThatListsAreEqual(mergedLists, expectedHead);
    }

    private void assertThatListsAreEqual(
            final Solution.SinglyLinkedListNode head1, final Solution.SinglyLinkedListNode head2
    ) throws IOException {
        try (
                final StringWriter stringWriter1 = new StringWriter();
                final BufferedWriter bufferedWriter1 = new BufferedWriter(stringWriter1); 
                final StringWriter stringWriter2 = new StringWriter();
                final BufferedWriter bufferedWriter2 = new BufferedWriter(stringWriter2);
        ) {

            Solution.printSinglyLinkedList(head1, " ", bufferedWriter1);
            bufferedWriter1.flush();           
            
            Solution.printSinglyLinkedList(head2, " ", bufferedWriter2);
            bufferedWriter2.flush();
            
            final String list1Str = stringWriter1.toString();
            final String list2Str = stringWriter2.toString();
            assertThat(list1Str).isEqualTo(list2Str);
        }
    }

    private static Stream<Arguments> provideParamsForResult() {
        return Stream.of(
                Arguments.of(
                        head1(), head2(), expectedHead()
                )
        );
    }

    private static Solution.SinglyLinkedListNode expectedHead() {
        final Solution.SinglyLinkedList list = new Solution.SinglyLinkedList();
        list.insertNode(1);
        list.insertNode(2);
        list.insertNode(3);
        list.insertNode(3);
        list.insertNode(4);

        return list.head;
    }

    private static Solution.SinglyLinkedListNode head2() {
        final Solution.SinglyLinkedList list = new Solution.SinglyLinkedList();
        list.insertNode(3);
        list.insertNode(4);

        return list.head;
    }

    private static Solution.SinglyLinkedListNode head1() {
        final Solution.SinglyLinkedList list = new Solution.SinglyLinkedList();
        list.insertNode(1);
        list.insertNode(2);
        list.insertNode(3);

        return list.head;
    }

}