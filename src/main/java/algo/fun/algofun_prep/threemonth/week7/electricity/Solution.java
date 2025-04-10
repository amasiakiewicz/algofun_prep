package algo.fun.algofun_prep.threemonth.week7.electricity;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'pylons' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int pylons(int k, List<Integer> arr) {
        int powerIndCount = 0;

        int fromInd = 0;
        int toInd = k - 1;
        
        while (fromInd + k <= arr.size()) {
            final int powerInd = createPowerInd(fromInd, toInd, arr);
            if (powerInd == -1) {
                return -1;
            }
            
            powerIndCount++;
            
            fromInd = powerInd + 1;
            toInd = fromInd + 2 * k - 2;
            toInd = Math.min(toInd, arr.size() - 1);
        }

        return powerIndCount;
    }

    private static int createPowerInd(final int fromInd, final int toInd, final List<Integer> arr) {
        for (int i = toInd; i >= fromInd; i--) {
            final Integer candidateInd = arr.get(i);
            if (candidateInd == 0) {
                continue;
            }
            
            return i;
        }
        
        return -1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pylons(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
