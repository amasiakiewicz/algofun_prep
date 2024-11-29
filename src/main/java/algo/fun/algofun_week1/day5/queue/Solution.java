package algo.fun.algofun_week1.day5.queue;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

    static class Queue {
        private final Deque<Integer> stack = new ArrayDeque<>();

        void enqueue(final int x) {
            stack.offer(x);
        }

        void dequeue() {
            stack.pollFirst();
        }

        void print() {
            System.out.println(stack.getFirst());
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
                queue.dequeue();
                return;
            }
            
            queue.print();
        });
    }
    
}


