package algo.fun.algofun_week1.day5.balancedbracket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    private static final Map<Character, Character> bracketMatchMap = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
    );

    public static String isBalanced(String s) {
        final Deque<Character> openingBracketsQueue = new ArrayDeque<>();

        final char[] chars = s.toCharArray();
        for (final char bracket : chars) {
            if (isOpening(bracket)) {
                openingBracketsQueue.offer(bracket);
                continue;
            }

            if (openingBracketsQueue.isEmpty()) {
                return "NO";
            }

            final Character openingBracket = openingBracketsQueue.pollLast();
            if (bracketsDontMatch(openingBracket, bracket)) {
                return "NO";
            }
        }
        
        return openingBracketsQueue.isEmpty() ? "YES" : "NO";
    }

    private static boolean bracketsDontMatch(final Character openingBracket, final Character closingBracket) {
        return !bracketMatchMap.get(closingBracket).equals(openingBracket);
    }

    private static boolean isOpening(final char bracket) {
        return bracket == '(' || bracket == '[' || bracket == '{';
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

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
