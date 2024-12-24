package algo.fun.algofun_prep.month.week3.icecream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        final Map<Integer, List<Integer>> costToIndMap = new HashMap<>();

        IntStream
                .range(0, arr.size())
                .forEach(i -> {
                    final Integer cost = arr.get(i);
                    final ArrayList<Integer> indexes = new ArrayList<>();
                    indexes.add(i + 1);

                    costToIndMap.merge(cost, indexes, (l1, l2) -> {
                        l1.addAll(l2);
                        return l1;
                    });
                });

        final ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            final Integer firstCost = arr.get(i);
            final int secondCost = m - firstCost;

            if (costToIndMap.containsKey(secondCost)) {

                final int firstCostInd = i + 1;
                final List<Integer> otherIndexes = costToIndMap
                        .get(secondCost)
                        .stream()
                        .filter(otherInd -> otherInd != firstCostInd)
                        .collect(toList());
                
                if (otherIndexes.isEmpty()) {
                    continue;
                }

                final Integer secondCostInd = otherIndexes.get(0);
                
                result.add(firstCostInd);
                result.add(secondCostInd);
                
                return result;
            }
        }

        return Collections.emptyList();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int m = Integer.parseInt(bufferedReader.readLine().trim());

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = Result.icecreamParlor(m, arr);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
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
