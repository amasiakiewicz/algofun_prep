package algo.fun.algofun_prep.threemonth.week4.closestnumber;

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
import java.util.TreeMap;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        final ArrayList<Integer> sortedArr = new ArrayList<>(arr);
        Collections.sort(sortedArr);

        Integer previousVal = sortedArr.get(0);
        final TreeMap<Integer, List<Integer>> diffToValMap = new TreeMap<>();

        for (int i = 1; i < sortedArr.size(); i++) {
            final Integer currentVal = sortedArr.get(i);
            final int diff = currentVal - previousVal;

            final List<Integer> values = diffToValMap.computeIfAbsent(diff, n -> new ArrayList<>());
            values.add(previousVal);
            values.add(currentVal);
            
            previousVal = currentVal;
        }

        return diffToValMap.firstEntry().getValue();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
