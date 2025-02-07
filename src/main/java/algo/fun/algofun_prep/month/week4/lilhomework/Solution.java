package algo.fun.algofun_prep.month.week4.lilhomework;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int lilysHomework(List<Integer> arr) {
        final ArrayList<Integer> sortedArr = new ArrayList<>(arr);
        Collections.sort(sortedArr);
        int sortSwaps = countSwaps(arr, sortedArr);

        final ArrayList<Integer> sortedReversedArr = new ArrayList<>(arr);
        sortedReversedArr.sort(Comparator.reverseOrder());
        int reversedSortSwaps =  countSwaps(arr, sortedReversedArr);

        return Math.min(sortSwaps, reversedSortSwaps);
    }

    private static int countSwaps(final List<Integer> arrImm, final ArrayList<Integer> sortedArr) {
        final ArrayList<Integer> arr = new ArrayList<>(arrImm);
        final Map<Integer, Integer> valueToIndMap = IntStream
                .range(0, sortedArr.size())
                .boxed()
                .collect(toMap(sortedArr::get, i -> i));

        int swaps = 0;
        
        for (int i = 0; i < arr.size(); i++) {
            final Integer correctValue = sortedArr.get(i);
            
            while (!arr.get(i).equals(correctValue)) {
                swap(arr, i, valueToIndMap);
                swaps++;
            }
            
        }
        
        return swaps;
    }

    private static void swap(
            final ArrayList<Integer> arr, final int i, final Map<Integer, Integer> valueToIndMap
    ) {
        final Integer currentInt = arr.get(i);
        final Integer properInd = valueToIndMap.get(currentInt);
        final Integer otherInt = arr.get(properInd);
        
        arr.set(i, otherInt);
        arr.set(properInd, currentInt);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
