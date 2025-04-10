package algo.fun.algofun_prep.threemonth.week9.twochar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Result {

    private static class FlaggedSB {
        private final StringBuilder sb = new StringBuilder();
        private boolean active = true;

        void condAppend(final char c) {
            if (!active) {
                return;
            }
            
            if (sb.isEmpty()) {
                sb.append(c);
                return;
            }

            final char lastChar = sb.charAt(sb.length() - 1);
            if (c != lastChar) {
                sb.append(c);
                return;
            }

            active = false;
        }

        int length() {
            return active ? sb.length() : 0;
        }
    }
    
    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {
        if (s.length() == 1) {
            return 0;
        }

        final Map<Character, Set<FlaggedSB>> charToStringsMap = new HashMap<>();

        for (char c1 = 'a'; c1 < 'z'; c1++) {
            for (char c2 = 'z'; c2 > c1; c2--) {
                final FlaggedSB sb = new FlaggedSB();
                charToStringsMap
                        .computeIfAbsent(c1, c -> new HashSet<>())
                        .add(sb);
                charToStringsMap
                        .computeIfAbsent(c2, c -> new HashSet<>())
                        .add(sb);
            }
        }

        final char[] sChars = s.toCharArray();
        for (final char c : sChars) {
            final Set<FlaggedSB> sbs = charToStringsMap.get(c);
            
            for (final FlaggedSB sb : sbs) {
                sb.condAppend(c);
            }
        }

        return charToStringsMap
                .values()
                .stream()
                .flatMap(Collection::stream)
                .mapToInt(FlaggedSB::length)
                .filter(l -> l > 1)
                .max()
                .orElse(0);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
