package algo.fun.algofun_prep.threemonth.week2.marsexploration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int marsExploration(String s) {
        int result = 0;
        final String ref = createRef(s);
        
        final char[] chars = s.toCharArray();
        final char[] refChars = ref.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != refChars[i]) {
                result++;
            } 
        }

        return result;
    }

    private static String createRef(final String s) {
        final String msg = "SOS";
        final int msgCount = s.length() / msg.length();
     
        return msg.repeat(msgCount);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
