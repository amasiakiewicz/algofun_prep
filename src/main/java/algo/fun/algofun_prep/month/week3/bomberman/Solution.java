package algo.fun.algofun_prep.month.week3.bomberman;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
        if (n == 1) {
            return grid;
        }

        if (n % 2 == 0) {
            return allGrid(grid);
        }

        if ((n - 5) % 4 == 0) {
            return clojureGrid(clojureGrid(grid));
        }

        return clojureGrid(grid);
    }

    private static List<String> clojureGrid(final List<String> grid) {
        final char[][] chars = grid
                .stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (chars[i][j] == 'O') {
                    blowBomb(chars, i, j);
                }
            }
        }

        return Arrays
                .stream(chars)
                .map(String::valueOf)
                .map(s -> s.replace('.', 'O'))
                .map(s -> s.replace('x', '.'))
                .collect(toList());
    }

    private static void blowBomb(final char[][] chars, final int i, final int j) {
        chars[i][j] = 'x';
        
        if (i + 1 < chars.length && chars[i + 1][j] == '.') {
            chars[i + 1][j] = 'x';
        }
        
        if (i - 1 >= 0 && chars[i - 1][j] == '.') {
            chars[i - 1][j] = 'x';
        }
        
        if (j + 1 < chars[i].length && chars[i][j + 1] == '.') {
            chars[i][j + 1] = 'x';
        }
        
        if (j - 1 >= 0 && chars[i][j - 1] == '.') {
            chars[i][j - 1] = 'x';
        }
    }

    private static List<String> allGrid(final List<String> grid) {
        return grid
                .stream()
                .map(s -> s.replace('.', 'O'))
                .collect(toList());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
