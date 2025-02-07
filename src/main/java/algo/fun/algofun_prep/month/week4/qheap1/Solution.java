package algo.fun.algofun_prep.month.week4.qheap1;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution {

    static class Queue {
        private final PriorityQueue<Integer> heap = new PriorityQueue<>();

        void enqueue(final int x) {
            heap.offer(x);
        }

        void dequeue(final int x) {
            heap.remove(x);
        }

        void printMin() {
            final int min = heap.peek();
            System.out.println(min);
        }
    }

    public static void main(String[] args) throws IOException {
        try (
                final InputStreamReader in = new InputStreamReader(System.in);
                final BufferedReader bufferedReader = new BufferedReader(in)
        ) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());

            final List<String> queries = IntStream
                    .range(0, q)
                    .mapToObj(i -> {
                        try {
                            return bufferedReader.readLine().trim();

                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .collect(toList());

            handle(queries);
        }

    }

    private static void handle(final List<String> queries) {
        final Queue queue = new Queue();

        queries.forEach(q -> {
            final String[] queryArr = q.split(" ");
            final int command = Integer.parseInt(queryArr[0]);
            if (command == 1) {
                final int value = Integer.parseInt(queryArr[1]);
                queue.enqueue(value);
                return;
            }

            if (command == 2) {
                final int value = Integer.parseInt(queryArr[1]);
                queue.dequeue(value);
                return;
            }

            queue.printMin();
        });
    }

}


