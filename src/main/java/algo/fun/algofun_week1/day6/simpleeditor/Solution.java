package algo.fun.algofun_week1.day6.simpleeditor;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

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
        final Deque<String> stringHistory = new ArrayDeque<>();
        final StringBuilder sb = new StringBuilder();

        queries.forEach(q -> {
            final String[] queryArr = q.split(" ");
            final int command = Integer.parseInt(queryArr[0]);
            if (command == 1) {
                final String strToAdd = queryArr[1];
                
                stringHistory.offer(sb.toString());
                sb.append(strToAdd);
                
                return;
            }

            if (command == 2) {
                final int charsToDelete = Integer.parseInt(queryArr[1]);

                stringHistory.offer(sb.toString());
                final int sbLength = sb.length();
                sb.delete(sbLength - charsToDelete, sbLength);

                return;
            }
            
            if (command == 3) {
                final int index = Integer.parseInt(queryArr[1]) - 1;

                System.out.println(sb.charAt(index));

                return;
            }

            final String lastString = stringHistory.pollLast();
            sb.setLength(0); 
            sb.append(lastString == null ? "" : lastString);
        });
    }
    
}
