package algo.fun.algofun_prep.threemonth.week5.countingsort;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
        final String result = countSortStr(arr);
        System.out.println(result);
    }

    static String countSortStr(final List<List<String>> arr) {
        final List<List<String>> arrStr = new ArrayList<>(arr);
        for (int i = 0; i < arrStr.size() / 2; i++) {
            final List<String> strings = arrStr.get(i);
            
            final List<String> newStrings = new ArrayList<>(strings);
            newStrings.set(1, "-");
            arrStr.set(i, newStrings);
        }

        final TreeMap<Integer, String> nrToStrMap = arrStr
                .stream()
                .collect(groupingBy(l -> {
                            final String nrStr = l.get(0);
                            return Integer.valueOf(nrStr);
                        }, TreeMap::new,
                        mapping(l -> l.get(1), joining(" "))
                ));
        
        return String.join(" ", nrToStrMap.values());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.countSort(arr);

        bufferedReader.close();
    }
}
