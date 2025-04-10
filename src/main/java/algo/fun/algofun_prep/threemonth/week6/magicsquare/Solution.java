package algo.fun.algofun_prep.threemonth.week6.magicsquare;

import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    private static class Matrix {
        private final List<List<Integer>> m;

        static Optional<Matrix> create(final int a, final int b) {
            if (isNotInScope(a) || isNotInScope(b) || a == b) {
                return empty();
            }

            int i = 10 - a;
            if (isNotInScope(i)) {
                return empty();
            }

            int h = 10 - b;
            if (isNotInScope(h)) {
                return empty();
            }
            
            int c = 15 - a - b;
            if (isNotInScope(c)) {
                return empty();
            }
            
            int g = 15 - h - i;
            if (isNotInScope(g)) {
                return empty();
            }
            
            int d = 15 - g - a;
            if (isNotInScope(d)) {
                return empty();
            }
            
            int f = 15 - c - i;
            if (isNotInScope(f)) {
                return empty();
            }

            final int size = Stream.of(a, b, c, d, f, g, h, i)
                    .collect(Collectors.toSet())
                    .size();
            if (size != 8) {
                return empty();
            }

            final List<List<Integer>> m = List.of(
                    List.of(a, b, c),
                    List.of(d, 5, f),
                    List.of(g, h, i)
            );
            final Matrix matrix = new Matrix(m);
            return Optional.of(matrix);
        }

        private Matrix(final List<List<Integer>> m) {
            this.m = m;
        }

        private static boolean isNotInScope(final int i) {
            return i < 1 || i > 9 || i == 5;
        }

        int distance(final List<List<Integer>> s) {
            int distance = 0;
            
            final List<Integer> flatM = m
                    .stream()
                    .flatMap(Collection::stream)
                    .collect(toList());
            final List<Integer> flatS = s
                    .stream()
                    .flatMap(Collection::stream)
                    .collect(toList());

            for (int i = 0; i < flatM.size(); i++) {
                final Integer mVal = flatM.get(i);
                final Integer sVal = flatS.get(i);
                distance += Math.abs(mVal - sVal);
            }
            
            return distance;
        }
    }

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        final List<Matrix> refMatrices = new ArrayList<>();

        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                Matrix
                        .create(a, b)
                        .ifPresent(refMatrices::add);
            }
        }
        
        return refMatrices
                .stream()
                .mapToInt(m -> m.distance(s))
                .min()
                .orElse(0);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
