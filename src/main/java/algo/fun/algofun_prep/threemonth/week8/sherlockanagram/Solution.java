package algo.fun.algofun_prep.threemonth.week8.sherlockanagram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        final Map<String, Integer> strToCountMap = new HashMap<>();
        
        for (int subStrLength = 1; subStrLength <= s.length(); subStrLength++) {
            for (int startInd = 0; startInd <= s.length() - subStrLength; startInd++) {
                final String sortedString = s
                        .substring(startInd, startInd + subStrLength)
                        .chars()
                        .sorted()
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                
                strToCountMap.merge(sortedString, 1, Integer::sum);
            }
        }
        
        return strToCountMap
                .values()
                .stream()
                .filter(n -> n != 1)
                .mapToInt(n -> n * (n - 1) / 2)
                .sum();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

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
