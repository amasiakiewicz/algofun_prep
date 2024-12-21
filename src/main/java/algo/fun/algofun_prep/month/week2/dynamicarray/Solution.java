package algo.fun.algofun_prep.month.week2.dynamicarray;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        final List<List<Integer>> arr = new ArrayList<>(n);
        final List<Integer> answers = new ArrayList<>();

        IntStream
                .range(0, n)
                .forEach(i -> {
                    final List<Integer> l = new ArrayList<>();
                    arr.add(l);
                });

        final int[] lastAnswer = { 0 };
        
        queries.forEach(q -> {
            final Integer queryType = q.get(0);
            final Integer x = q.get(1);
            final Integer y = q.get(2);

            final int ind = (x ^ lastAnswer[0]) % n;
            
            if (queryType == 1) {
                arr.get(ind).add(y);
                return;
            }

            final List<Integer> l = arr.get(ind);
            final int secondInd = y % l.size();
            
            lastAnswer[0] = l.get(secondInd);
            answers.add(lastAnswer[0]);
        });
        
        return answers;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

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
