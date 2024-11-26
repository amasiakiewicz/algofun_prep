package algo.fun.algofun_week1.day3.caesarcipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        final int kMod = k % 26;
        if (kMod == 0) {
            return s;
        }

        return s.chars()
                .mapToObj(charI -> {
                    char c = (char) charI;
                    if (!Character.isLetter(c)) {
                        return c;
                    }

                    final int offset = Character.isUpperCase(c)
                            ? Character.codePointAt("A", 0)
                            : Character.codePointAt("a", 0);

                    final int newCharI = (charI - offset + kMod) % 26 + offset;
                    return (char) newCharI;
                })
                .map(Objects::toString)
                .collect(Collectors.joining());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
