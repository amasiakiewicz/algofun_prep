package algo.fun.algofun_prep.threemonth.week10.permutation;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    static HashMap<ArrayList<Integer>, String> result = new HashMap<ArrayList<Integer>, String>();
    
    /*
     * Complete the 'permutationGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    
    public static String permutationGame(List<Integer> arr) {
        final Map<List<Integer>, String> arrToWinnerMap = new HashMap<>();
        return getWinner(arr, "Alice", arrToWinnerMap);
    }

    private static String getWinner(
            final List<Integer> arr, final String player, final Map<List<Integer>, String> arrToWinnerMap
    ) {
        if (arrToWinnerMap.containsKey(arr)) {
            return arrToWinnerMap.get(arr);
        }
        
        for (int i = 0; i < arr.size(); i++) {
            final List<Integer> shorterArr = createArrWithoutI(arr, i);
            if (isIncreasing(shorterArr)) {
                arrToWinnerMap.put(arr, player);
                return player;
            }
            
            final String otherPlayer = getOtherPlayer(player);
            final String winner = getWinner(shorterArr, otherPlayer, arrToWinnerMap);
            if (winner.equals(player)) {
                arrToWinnerMap.put(arr, player);
                return player;
            }
        }

        final String otherPlayer = getOtherPlayer(player);
        arrToWinnerMap.put(arr, otherPlayer);
        return otherPlayer;
    }

    private static String getOtherPlayer(final String player) {
        if (player.equals("Alice")) {
            return "Bob";
        }
        
        return "Alice";
    }

    private static List<Integer> createArrWithoutI(final List<Integer> arr, final int i) {
        final ArrayList<Integer> shorterArr = new ArrayList<>(arr);
        shorterArr.remove(i);
        return shorterArr;
    }

    private static boolean isIncreasing(final List<Integer> arr) {
        int prevV = 0;

        for (final Integer v : arr) {
            if (v <= prevV) {
                return false;
            }

            prevV = v;
        }

        return true;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result.permutationGame(arr);

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
