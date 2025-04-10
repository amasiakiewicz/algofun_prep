package algo.fun.algofun_prep.threemonth.week4.separatenumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
        final String result = createSeparateNumbers(s);
        System.out.println(result);
    }

    static String createSeparateNumbers(final String s) {
        final int sLength = s.length();
        if (sLength == 1) {
            return "NO";
        }

        for (int i = 1; i <= sLength / 2; i++) {
            final String prefix = s.substring(0, i);
            final String refStr = createRefStr(prefix, sLength);

            if (s.equals(refStr)) {
                return String.format("YES %s", prefix);
            }
        }

        return "NO";
    }

    private static String createRefStr(final String prefix, final int sLength) {
        long nrSeq = Long.parseLong(prefix);
        final StringBuilder stringBuilder = new StringBuilder(prefix);
        
        while (stringBuilder.length() < sLength) {
            nrSeq++;
            stringBuilder.append(nrSeq);
        }
        
        return stringBuilder.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
