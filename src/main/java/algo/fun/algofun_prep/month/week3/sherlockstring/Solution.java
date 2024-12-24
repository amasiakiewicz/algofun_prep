package algo.fun.algofun_prep.month.week3.sherlockstring;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        final List<Integer> occurrences = s
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c))
                .values()
                .stream()
                .map(List::size)
                .sorted()
                .collect(Collectors.toList());

        if (new HashSet<>(occurrences).size() == 1) {
            return "YES";
        }

        final Integer firstOcc = occurrences.get(1);
        final Integer lastOcc = occurrences.get(occurrences.size() - 1);

        if (occurrences.get(0) == 1 && firstOcc.equals(lastOcc)) {
            return "YES";
        }

        final Integer secondLastOcc = occurrences.get(occurrences.size() - 2);

        if (occurrences.get(0).equals(secondLastOcc) && lastOcc - 1 == secondLastOcc) {
            return "YES";
        }
        
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
