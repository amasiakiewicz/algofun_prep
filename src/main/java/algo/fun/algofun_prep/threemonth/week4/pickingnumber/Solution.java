package algo.fun.algofun_prep.threemonth.week4.pickingnumber;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        final TreeMap<Integer, Long> freq = a
                .stream()
                .collect(groupingBy(i -> i, TreeMap::new, counting()));

        Map.Entry<Integer, Long> prevEntry = null;
        int maxLength = 0;
        
        for (final Map.Entry<Integer, Long> entry : freq.entrySet()) {
            maxLength = Math.max(maxLength, entry.getValue().intValue());
            
            if (prevEntry == null) {
                prevEntry = entry;
                continue;
            }

            if (Math.abs(entry.getKey() - prevEntry.getKey()) <= 1) {
                final int currentLength = (int) (prevEntry.getValue() + entry.getValue());
                maxLength = Math.max(maxLength, currentLength);
            }
            
            prevEntry = entry;
        }
        
        return maxLength;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
