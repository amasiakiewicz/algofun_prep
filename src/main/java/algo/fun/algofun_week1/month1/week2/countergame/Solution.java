package algo.fun.algofun_week1.month1.week2.countergame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class Result {
    public static final String RICHARD = "Richard";
    public static final String LOUISE = "Louise";

    /*
     * Complete the 'counterGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static String counterGame(long n) {
        if (n == 1) {
            return RICHARD;
        }

        int steps = 0;
        
        while (n > 1) {
            steps++;
            
            long pwr = getPwr(n);
            
            if (n == pwr) {
                n /= 2;
                continue;
            }
            
            n -= pwr;
        }
        
        return steps % 2 == 1 ? LOUISE : RICHARD;
    }

    private static long getPwr(final long n) {
        long result = 1;
        final long nHalf = n / 2;

        while (result <= nHalf) {
            result *= 2;
        }
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = Result.counterGame(n);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
