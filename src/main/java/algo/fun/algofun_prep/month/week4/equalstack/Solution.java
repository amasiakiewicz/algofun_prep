package algo.fun.algofun_prep.month.week4.equalstack;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        if (h1.isEmpty() || h2.isEmpty() || h3.isEmpty()) {
            return 0;
        }
        
        final List<Integer> h1Sums = sumStackHeights(h1);
        Collections.reverse(h1Sums);
        
        final List<Integer> h2Sums = sumStackHeights(h2);
        final HashSet<Integer> h2SumSet = new HashSet<>(h2Sums);

        final List<Integer> h3Sums = sumStackHeights(h3);
        final HashSet<Integer> h3SumSet = new HashSet<>(h3Sums);

        for (final Integer sum : h1Sums) {
            if (h2SumSet.contains(sum) && h3SumSet.contains(sum)) {
                return sum;
            }
        }
        
        return 0;
    }

    private static List<Integer> sumStackHeights(final List<Integer> stack) {
        final ArrayList<Integer> localStack = new ArrayList<>(stack);
        
        final ArrayList<Integer> sums = new ArrayList<>();
        final int[] sum = { 0 };
        
        Collections.reverse(localStack);
        localStack.forEach(i -> {
            sum[0] += i;
            sums.add(sum[0]);
        });
        
        return sums;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
