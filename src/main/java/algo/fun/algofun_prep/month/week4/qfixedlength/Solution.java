package algo.fun.algofun_prep.month.week4.qfixedlength;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY queries
     */

    public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
        final int arrSize = arr.size();

        return queries
                .stream()
                .map(q -> {
                    final Deque<Integer> subArr = new ArrayDeque<>(arr.subList(0, q));
                    final Integer[] max = {
                            getMax(subArr)
                    };

                    final TreeSet<Integer> maxValues = new TreeSet<>();
                    maxValues.add(max[0]);

                    IntStream
                            .range(q, arrSize)
                            .forEach(i -> {
                                final Integer firstElement = subArr.removeFirst();
                                final Integer newElement = arr.get(i);
                                subArr.add(newElement);
                                
                                if (firstElement.equals(max[0])) {
                                    max[0] = getMax(subArr);
                                } else if (newElement > max[0]) {
                                    max[0] = newElement;
                                }
                                
                                maxValues.add(max[0]);
                            });

                    return maxValues.first();

                })
                .collect(toList());
    }

    private static Integer getMax(final Deque<Integer> subArr) {
        return subArr
                .stream()
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.solve(arr, queries);

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
