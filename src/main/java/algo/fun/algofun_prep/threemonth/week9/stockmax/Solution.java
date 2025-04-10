package algo.fun.algofun_prep.threemonth.week9.stockmax;

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
     * Complete the 'stockmax' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY prices as parameter.
     */

    public static long stockmax(List<Integer> prices) {
        long profit = 0;
        int items = 0;
        
        final int[] rightMaxes = createRightMaxes(prices);

        for (int i = 0; i < prices.size(); i++) {
            final Integer price = prices.get(i);
            final int rightMax = rightMaxes[i];
            if (price < rightMax) {
                profit -= price;
                items++;
                continue;
            }
            
            profit += (long) items * price;
            items = 0;
        }
        
        return profit;
    }

    private static int[] createRightMaxes(final List<Integer> prices) {
        final int pricesSize = prices.size();
        final int[] maxes = new int[pricesSize];
        int max = 0;
        
        for (int i = pricesSize - 1; i >= 0; i--) {
            final Integer price = prices.get(i);
            max = Math.max(price, max);
            maxes[i] = max;
        }
        
        return maxes;
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

                List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                long result = Result.stockmax(prices);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
