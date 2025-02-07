package algo.fun.algofun_prep.month.week4.roadandlibrary;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> links) {
        if (c_lib <= c_road) {
            return (long) c_lib * n;
        }

        final Map<Integer, Set<Integer>> cityToCitiesMap = new HashMap<>();
        long roadsCount = 0L;

        for (final List<Integer> link : links) {
            final Integer cityA = link.get(0);
            final Integer cityB = link.get(1);

            final Set<Integer> citiesA = cityToCitiesMap.computeIfAbsent(cityA, c -> new HashSet<>());

            if (citiesA.contains(cityB)) {
                continue;
            }

            citiesA.add(cityA);

            final Set<Integer> citiesB = cityToCitiesMap.getOrDefault(cityB, new HashSet<>());
            citiesB.add(cityB);

            citiesA.addAll(citiesB);

            for (final Integer city : citiesB) {
                cityToCitiesMap.put(city, citiesA);
            }

            roadsCount++;
        }

        long libCount = getLibCount(n, cityToCitiesMap);

        return c_road * roadsCount + c_lib * libCount;
    }

    private static long getLibCount(final int n, final Map<Integer, Set<Integer>> cityToCitiesMap) {
        final long cityGroups = cityToCitiesMap
                .values()
                .stream()
                .distinct()
                .count();

        return n - cityToCitiesMap.size() + cityGroups;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

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
