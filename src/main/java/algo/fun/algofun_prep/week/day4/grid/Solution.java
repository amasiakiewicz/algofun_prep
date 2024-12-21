package algo.fun.algofun_prep.week.day4.grid;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        final List<StringBuilder> columnGridSb = new ArrayList<>();

        grid.forEach(s -> {
            final char[] arr = s.toCharArray();
            Arrays.sort(arr);

            IntStream
                    .range(0, arr.length)
                    .forEach(i -> {
                        final char c = arr[i];
                        if (columnGridSb.size() == i) {
                            final StringBuilder sb = new StringBuilder();
                            columnGridSb.add(i, sb);
                        } 
                        
                        columnGridSb
                                .get(i)
                                .append(c);
                    });
        });

        final List<String> columnGrid = columnGridSb
                .stream()
                .map(StringBuilder::toString)
                .collect(toList());

        final List<String> sortedColumnGrid = columnGrid
                .stream()
                .map(s -> {
                    final char[] arr = s.toCharArray();
                    Arrays.sort(arr);
                    return new String(arr);
                })
                .collect(toList());

        return columnGrid.equals(sortedColumnGrid) ? "YES" : "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String result = Result.gridChallenge(grid);

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
