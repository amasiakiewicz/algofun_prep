package algo.fun.algofun_prep.week.day4.newyear;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        final String bribesResult = minimumBribesResult(q);
        System.out.println(bribesResult);
    }

    static String minimumBribesResult(final List<Integer> q) {
        try {
            int allBribes = getAllBribes(q);
            return String.valueOf(allBribes);
        } catch (Exception e) {
            return "Too chaotic";
        }
    }

    private static int getAllBribes(final List<Integer> q) {
        final int qSize = q.size();
        final int[] bribers = new int[qSize];
        
        return IntStream
                .range(0, qSize)
                .map(i -> {
                    final int stickerVal = q.get(i);
                    final int normalizedPos = i + 1;
                    if (stickerVal == normalizedPos) {
                        return 0;
                    }

                    if (stickerVal < normalizedPos) {
                        final int shifts = normalizedPos - stickerVal;
                        final int bribersCount = Arrays
                                .stream(bribers, stickerVal - 1, qSize)
                                .sum();
                        final int shiftsDiff = shifts - bribersCount;
                        return Math.max(shiftsDiff, 0);
                    }

                    final int bribes = stickerVal - normalizedPos;
                    if (bribes <= 2) {
                        bribers[stickerVal - 1] = 1;
                        return bribes;
                    }

                    throw new IllegalStateException();
                })
                .sum();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
