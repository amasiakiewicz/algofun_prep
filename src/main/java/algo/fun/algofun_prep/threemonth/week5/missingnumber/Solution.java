package algo.fun.algofun_prep.threemonth.week5.missingnumber;

import static java.util.stream.Collectors.counting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */


    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        final TreeMap<Integer, Long> arrFreq = arr
                .stream()
                .collect(Collectors.groupingBy(i -> i, TreeMap::new, counting()));
        
        final TreeMap<Integer, Long> brrFreq = brr
                .stream()
                .collect(Collectors.groupingBy(i -> i, TreeMap::new, counting()));

        final List<Integer> result = new ArrayList<>();
        
        for (final Map.Entry<Integer, Long> brrFreqEntry : brrFreq.entrySet()) {
            final Integer number = brrFreqEntry.getKey();
            
            if (!arrFreq.containsKey(number)) {
                result.add(number);
                continue;
            }

            final Long brrCount = brrFreqEntry.getValue();
            final Long arrCount = arrFreq.get(number);

            if (arrCount < brrCount) {
                result.add(number);
            }
        }
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        List<Integer> result = Result.missingNumbers(arr, brr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
