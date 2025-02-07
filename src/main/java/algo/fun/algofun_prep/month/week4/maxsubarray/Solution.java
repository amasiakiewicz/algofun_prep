package algo.fun.algofun_prep.month.week4.maxsubarray;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {

        final boolean allNegative = arr
                .stream()
                .noneMatch(i -> i > 0);

        if (allNegative) {
            final int max = arr
                    .stream()
                    .mapToInt(i -> i)
                    .max()
                    .orElse(0);
            
            return List.of(max, max);
        }

        final int[] subArrSum = { arr.get(0) };
        final int[] localSubArrSum = { arr.get(0) };

        IntStream
                .range(1, arr.size())
                .forEach(i -> {
                    final Integer val = arr.get(i);
                    if (val > 0 && subArrSum[0] < 0) {
                        subArrSum[0] = 0;
                    }
                    
                    if (val < 0) {
                        localSubArrSum[0] = Math.max(localSubArrSum[0], subArrSum[0]);
                    }

                    subArrSum[0] += val;
                });

        subArrSum[0] = Math.max(localSubArrSum[0], subArrSum[0]);

        final int subSeqSum = arr
                .stream()
                .mapToInt(i -> i)
                .filter(i -> i > 0)
                .sum();

        return List.of(subArrSum[0], subSeqSum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
