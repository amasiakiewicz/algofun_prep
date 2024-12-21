package algo.fun.algofun_prep.week.day1.minimaxsum;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        final List<Long> results = miniMaxSumResult(arr);
        results.forEach(l -> System.out.printf("%d ", l));
    }

    static List<Long> miniMaxSumResult(final List<Integer> arr) {
        final long sum = arr
                .stream()
                .mapToLong(i -> i)
                .sum();
        final long min = arr
                .stream()
                .mapToLong(i -> i)
                .min()
                .orElse(0L);
        final long max = arr
                .stream()
                .mapToLong(i -> i)
                .max()
                .orElse(0L);

        final long sumMax = sum - min;
        final long sumMin = sum - max;

        return List.of(sumMin, sumMax);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
