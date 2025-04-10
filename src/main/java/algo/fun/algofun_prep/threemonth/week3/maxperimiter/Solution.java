package algo.fun.algofun_prep.threemonth.week3.maxperimiter;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Result {

    static class Trio {
        int a, b, c;

        Trio(final int a, final int b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        List<Integer> sides() {
            return Stream.of(a, b, c)
                    .sorted()
                    .collect(toList());
        }

    }

    /*
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        final List<Trio> triangles = new ArrayList<>();

        final int size = sticks.size();
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    final int a = sticks.get(i);
                    final int b = sticks.get(j);
                    final int c = sticks.get(k);

                    if (isTriangle(a, b, c)) {
                        final Trio triangle = new Trio(a, b, c);
                        triangles.add(triangle);
                    }
                }
            }
        }

        return triangles
                .stream()
                .max(Result::compare)
                .map(Trio::sides)
                .orElse(List.of(-1));
    }

    private static boolean isTriangle(final int a, final int b, final int c) {
        return a + b > c && a + c > b && b + c > a;
    }

    private static int compare(final Trio t1, final Trio t2) {
        return Comparator.<Trio, Integer>comparing(t -> t.a + t.b + t.c)
                .thenComparing(t -> max(t.a, max(t.b, t.c)))
                .thenComparing(t -> min(t.a, min(t.b, t.c)), reverseOrder())
                .compare(t1, t2);
    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.maximumPerimeterTriangle(sticks);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
