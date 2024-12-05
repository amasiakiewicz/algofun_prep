package algo.fun.algofun_week1.day7.noprefixset;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     */

    public static void noPrefix(List<String> words) {
        final List<String> results = noPrefixStr(words);
        results.forEach(System.out::println);
    }

    static List<String> noPrefixStr(final List<String> words) {
        final Set<String> prefixes = new HashSet<>();
        final Set<String> visitedWords = new HashSet<>();

        for (final String w : words) {
            final List<String> badSetResults = List.of("BAD SET", w);
            
            if (prefixes.contains(w)) {
                return badSetResults;
            }

            for (int i = 1; i <= w.length(); i++) {
                final String substring = w.substring(0, i);
                
                if (visitedWords.contains(substring)) {
                   return badSetResults; 
                }
                
                prefixes.add(substring);
            }
            
            visitedWords.add(w);
        }
        
       return  List.of("GOOD SET"); 
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        Result.noPrefix(words);

        bufferedReader.close();
    }
}
