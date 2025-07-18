package algo.fun.algofun_prep.threemonth.week13.minimumloss;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'minimumLoss' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts LONG_INTEGER_ARRAY price as parameter.
     */
    
    private static class PriceIndex implements Comparable<PriceIndex> {
        long price;
        int index;

        PriceIndex(final long price, final int index) {
            this.price = price;
            this.index = index;
        }

        @Override
        public int compareTo(final PriceIndex o) {
            if (o == null) {
                return 0;
            }
            
            return Long.compare(price, o.price);
        }
    }

    public static long minimumLoss(List<Long> price) {
        final List<PriceIndex> priceIndexes = IntStream.range(0, price.size())
                .mapToObj(i -> new PriceIndex(price.get(i), i))
                .sorted(Comparator.reverseOrder())
                .collect(toList());

        long diff = Long.MAX_VALUE;
        PriceIndex previousPI = priceIndexes.get(0);
        
        for (int i = 1; i < priceIndexes.size(); i++) {
            final PriceIndex currentPI = priceIndexes.get(i);
            if (previousPI.index < currentPI.index) {
                final long candidateDiff = previousPI.price - currentPI.price;
                diff = Math.min(diff, candidateDiff);
            }
            
            previousPI = currentPI;
        }

        return diff;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> price = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long result = Result.minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
