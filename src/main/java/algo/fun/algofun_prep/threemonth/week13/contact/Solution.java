package algo.fun.algofun_prep.threemonth.week13.contact;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'contacts' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_STRING_ARRAY queries as parameter.
     */

    public static List<Integer> contacts(List<List<String>> queries) {

        final Map<String, AtomicInteger> prefixToCountMap = new HashMap<>();
        final List<Integer> namesCounts = new ArrayList<>();

        for (final List<String> query : queries) {
            final String operation = query.get(0);
            final String name = query.get(1);

            if (operation.equals("add")) {
                addName(name, prefixToCountMap);
                continue;
            }

            final int namesCount = findPartial(name, prefixToCountMap);
            namesCounts.add(namesCount);
        }

        return namesCounts;
    }

    private static int findPartial(final String partialName, final Map<String, AtomicInteger> prefixToCountMap) {
        return prefixToCountMap.getOrDefault(partialName, new AtomicInteger()).get();
    }

    private static void addName(final String name, final Map<String, AtomicInteger> prefixToCountMap) {
        for (int i = 0; i <= name.length(); i++) {
            final String subName = name.substring(0, i);
            prefixToCountMap.computeIfAbsent(subName, s -> new AtomicInteger())
                    .incrementAndGet();
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.contacts(queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
