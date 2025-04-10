package algo.fun.algofun_prep.threemonth.week5.strongpassword;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

class Result {
    private static final String NUMBERS = "0123456789";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+";

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
        int result = 0;
        if (dontContains(password, NUMBERS)) {
            result++;
        }
        
        if (dontContains(password, LOWER_CASE)) {
            result++;
        }     
        
        if (dontContains(password, UPPER_CASE)) {
            result++;
        }     
        
        if (dontContains(password, SPECIAL_CHARACTERS)) {
            result++;
        }
        
        int diff = 6 - (n + result);
        if (diff > 0) {
            result += diff;
        }
        
        return result;
    }

    private static boolean dontContains(final String password, final String ref) {
        final Set<Character> passChars = password.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        
        final Set<Character> refChars = ref.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        passChars.retainAll(refChars);
        
        return passChars.isEmpty();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
