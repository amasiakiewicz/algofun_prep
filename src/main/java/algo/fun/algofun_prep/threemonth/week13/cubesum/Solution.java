package algo.fun.algofun_prep.threemonth.week13.cubesum;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'cubeSum' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY operations
     */

    public static List<Long> cubeSum(int n, List<String> operations) {

        long[][][] cube = new long[n + 1][n + 1][n + 1];
        final List<Long> sums = new ArrayList<>();

        for (final String operation : operations) {
            final String[] opParts = operation.split(" ");
            final String action = opParts[0];

            if (action.equals("UPDATE")) {
                updateCube(cube, opParts);
                continue;
            }
            
            long sum = calculateSum(cube, opParts);
            sums.add(sum);
        }

        return sums;
    }

    private static long calculateSum(final long[][][] cube, final String[] opParts) {
        final int x1 = Integer.parseInt(opParts[1]);
        final int y1 = Integer.parseInt(opParts[2]);
        final int z1 = Integer.parseInt(opParts[3]);
        final int x2 = Integer.parseInt(opParts[4]);
        final int y2 = Integer.parseInt(opParts[5]);
        final int z2 = Integer.parseInt(opParts[6]);

        long sum = 0;
        
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    sum += cube[i][j][k];
                }
            }
        }
        
        return sum;
    }

    private static void updateCube(final long[][][] cube, final String[] opParts) {
        final int x = Integer.parseInt(opParts[1]);
        final int y = Integer.parseInt(opParts[2]);
        final int z = Integer.parseInt(opParts[3]);
        final long v = Long.parseLong(opParts[4]);
        
        cube[x][y][z] = v;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int matSize = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<String> ops = IntStream.range(0, m).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                List<Long> res = Result.cubeSum(matSize, ops);

                bufferedWriter.write(
                        res.stream()
                                .map(Object::toString)
                                .collect(joining("\n"))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
