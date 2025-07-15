package algo.fun.algofun_prep.threemonth.week13.runningmedian;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {

        final List<Double> medians = new ArrayList<>();
        final List<Integer> sortedA = new ArrayList<>();

        for (final Integer val : a) {
            int indexToInsert = Collections.binarySearch(sortedA, val);
            indexToInsert = indexToInsert < 0 ? - 1 - indexToInsert : indexToInsert;
            
            sortedA.add(indexToInsert, val);

            final double median = calculateMedian(sortedA);
            medians.add(median);
        }

        return medians;
    }

    private static double calculateMedian(final List<Integer> sortedA) {
        final int size = sortedA.size();
        int middleInd = (size - 1) / 2;
        
        if (size % 2 == 1) {
            return sortedA.get(middleInd).doubleValue();
        }

        final int middleSum = sortedA.get(middleInd) + sortedA.get(middleInd + 1);
        return middleSum / 2.0;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

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
