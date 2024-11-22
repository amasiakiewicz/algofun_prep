package algo.fun.algofun_week1.day1.plusminus;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        final List<String> results = plusMinusResult(arr);
        results.forEach(System.out::println);
    }

    static List<String> plusMinusResult(final List<Integer> arr) {
        final int allElements = arr.size();
        final long positives = arr
                .stream()
                .filter(i -> i > 0)
                .count();
        final long negatives = arr
                .stream()
                .filter(i -> i < 0)
                .count();
        final long zeros = allElements - positives - negatives;

        final BigDecimal allElementsD = BigDecimal.valueOf(allElements);
        final MathContext mc = new MathContext(6);

        final BigDecimal positiveProp = BigDecimal.valueOf(positives).divide(allElementsD, mc);
        final BigDecimal negativeProp = BigDecimal.valueOf(negatives).divide(allElementsD, mc);
        final BigDecimal zeroProp = BigDecimal.valueOf(zeros).divide(allElementsD, mc);

        return Stream.of(positiveProp, negativeProp, zeroProp)
                .map(p -> String.format("%.6f", p))
                .collect(toList());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
