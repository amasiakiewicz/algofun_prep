package algo.fun.algofun_prep.threemonth.week13.journeymoon;

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
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */

    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        final List<Integer> groupSizes = calculateGroupSizes(astronaut);
        
        long totalPairs = (long) n * (n - 1) / 2;
        final long countryPairs = groupSizes
                .stream()
                .mapToLong(k -> (long) k * (k - 1) / 2)
                .sum();

        return totalPairs - countryPairs;
    }

    private static List<Integer> calculateGroupSizes(final List<List<Integer>> astronaut) {
        final Map<Integer, Set<Integer>> idToAstronautsMap = new HashMap<>();

        for (final List<Integer> astrPair : astronaut) {
            final Integer firstAstr = astrPair.get(0);
            final Integer secondAstr = astrPair.get(1);

            final Set<Integer> firstAstrSet = 
                    idToAstronautsMap.getOrDefault(firstAstr, new HashSet<>());
            firstAstrSet.add(firstAstr);
            
            final Set<Integer> secondAstrSet = 
                    idToAstronautsMap.getOrDefault(secondAstr, new HashSet<>());
            secondAstrSet.add(secondAstr);
            
            firstAstrSet.addAll(secondAstrSet);
            idToAstronautsMap.put(firstAstr, firstAstrSet);
            
            for (final Integer astr : secondAstrSet) {
                idToAstronautsMap.put(astr, firstAstrSet);
            }
        }
        
        return idToAstronautsMap
                .values()
                .stream()
                .distinct()
                .map(Set::size)
                .collect(toList());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
