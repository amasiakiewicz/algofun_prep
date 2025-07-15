package algo.fun.algofun_prep.threemonth.week9.chiefhopper;

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
     * Complete the 'chiefHopper' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int chiefHopper(List<Integer> arr) {
        int lowEnd = 1;
        int highEnd = 100_000;
        int startEnergy = pickEnergy(lowEnd, highEnd);
        long finalEnergy = calculateFinalEnergy(startEnergy, arr);

        while (lowEnd != highEnd) {
            if (finalEnergy < 0) {
                lowEnd = Math.min(highEnd, startEnergy + 1);
            } else {
                highEnd = Math.max(lowEnd, startEnergy - 1);
            }
            
            startEnergy = pickEnergy(lowEnd, highEnd);
            finalEnergy = calculateFinalEnergy(startEnergy, arr);
        }

        return finalEnergy >= 0 ? lowEnd : lowEnd + 1;
    }

    private static long calculateFinalEnergy(final int startEnergy, final List<Integer> arr) {
        long finalEnergy = startEnergy;

        for (final Integer height : arr) {
            finalEnergy = finalEnergy - height + finalEnergy;
            if (finalEnergy > Integer.MAX_VALUE) {
                return 1;
            }
            if (finalEnergy < 0) {
                return -1;
            }
        }
        
        return finalEnergy;
    }

    private static int pickEnergy(final int lowEnd, final int highEnd) {
        return (highEnd + lowEnd) / 2;
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

        int result = Result.chiefHopper(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
