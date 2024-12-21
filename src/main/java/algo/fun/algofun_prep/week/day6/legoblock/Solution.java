package algo.fun.algofun_prep.week.day6.legoblock;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {
    public static final long MODULITH = 1_000_000_007L;

    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int legoBlocks(int n, int m) {
        final List<Long> singleRowLayouts = legoBlocks(m);
        final List<Long> gridLayouts = gridLayout(n, singleRowLayouts);
        final List<Long> goodLayouts = goodLayouts(gridLayouts);

        return (int) (goodLayouts.get(m - 1) % MODULITH);
    }

    private static List<Long> goodLayouts(final List<Long> gridLayouts) {
        final int gridSize = gridLayouts.size();
        final List<Long> result = new ArrayList<>(gridSize);
        result.add(1L);

        if (gridSize == 1) {
            return result;
        }

        IntStream
                .range(1, gridSize)
                .forEach(i -> {
                    final long badLayoutsCount = IntStream
                            .rangeClosed(0, i - 1)
                            .mapToLong(j -> result.get(j) * gridLayouts.get(i - 1 - j) % MODULITH)
                            .sum() % MODULITH;

                    final long goodLayoutsCount = Math.floorMod(gridLayouts.get(i) - badLayoutsCount, MODULITH);
                    result.add(goodLayoutsCount);
                });

        return result;
    }

    private static List<Long> gridLayout(final int n, final List<Long> singleRowLayout) {
        return singleRowLayout
                .stream()
                .map(i -> pow(i, n))
                .collect(Collectors.toList());
    }

    private static long pow(final Long baseNumber, final int n) {
        long result = 1L;
        for (int i = 0; i < n; i++) {
            result *= baseNumber;
            result %= MODULITH;
        }
        return result;
    }

    private static List<Long> legoBlocks(final int m) {
        final List<Long> result = new ArrayList<>(m);
        result.add(1L);

        if (m == 1) {
            return result;
        }

        result.add(2L);
        if (m == 2) {
            return result;
        }

        result.add(4L);
        if (m == 3) {
            return result;
        }

        result.add(8L);
        if (m == 4) {
            return result;
        }

        IntStream
                .range(4, m)
                .forEach(i -> {
                    final long newLayout =
                            (result.get(i - 1) + result.get(i - 2) + result.get(i - 3)
                                    + result.get(i - 4)) % MODULITH;
                    result.add(newLayout);
                });

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.legoBlocks(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
