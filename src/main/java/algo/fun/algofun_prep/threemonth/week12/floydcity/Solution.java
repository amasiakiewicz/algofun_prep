package algo.fun.algofun_prep.threemonth.week12.floydcity;

import static java.lang.Integer.MAX_VALUE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] roadNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int roadNodes = Integer.parseInt(roadNodesEdges[0]);
        int roadEdges = Integer.parseInt(roadNodesEdges[1]);

        List<Integer> roadFrom = new ArrayList<>();
        List<Integer> roadTo = new ArrayList<>();
        List<Integer> roadWeight = new ArrayList<>();

        IntStream.range(0, roadEdges).forEach(i -> {
            try {
                String[] roadFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                roadFrom.add(Integer.parseInt(roadFromToWeight[0]));
                roadTo.add(Integer.parseInt(roadFromToWeight[1]));
                roadWeight.add(Integer.parseInt(roadFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int q = Integer.parseInt(bufferedReader.readLine().trim());
        final List<Integer> xs = new ArrayList<>();
        final List<Integer> ys = new ArrayList<>();

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                xs.add(Integer.parseInt(firstMultipleInput[0]));

                ys.add(Integer.parseInt(firstMultipleInput[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        final List<Integer> distances = calculateDistances(roadNodes, roadFrom, roadTo, roadWeight, xs, ys);

        distances.forEach(d -> {
            try {
                bufferedWriter.write(String.valueOf(d));
                bufferedWriter.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    static List<Integer> calculateDistances(
            final int nodes, final List<Integer> roadFrom, final List<Integer> roadTo,
            final List<Integer> roadWeight, final List<Integer> xs, final List<Integer> ys
    ) {
        final List<Integer> distances = new ArrayList<>();

        final int[][] allDistances = createAllDistances(nodes, roadFrom, roadTo, roadWeight);

        for (int i = 0; i < xs.size(); i++) {
            final Integer x = xs.get(i);
            final Integer y = ys.get(i);

            int distance = getDistance(x, y, allDistances);
            distances.add(distance);
        }

        return distances;
    }

    private static int getDistance(final Integer x, final Integer y, final int[][] allDistances) {
        final int distance = allDistances[x][y];
        return distance == MAX_VALUE ? -1 : distance;
    }

    private static int[][] createAllDistances(
            final int nodes, final List<Integer> roadFrom, final List<Integer> roadTo,
            final List<Integer> roadWeight
    ) {
        final int[][] allDistances = new int[nodes + 1][nodes + 1];

        for (int i = 0; i <= nodes; i++) {
            for (int j = 0; j <= nodes; j++) {
                allDistances[i][j] = i == j ? 0 : MAX_VALUE;
            }
        }

        for (int i = 0; i < roadFrom.size(); i++) {
            final Integer from = roadFrom.get(i);
            final Integer to = roadTo.get(i);
            final Integer weight = roadWeight.get(i);

            allDistances[from][to] = weight;
        }

        for (int i = 1; i <= nodes; i++) {
            for (int j = 1; j <= nodes; j++) {
                for (int k = 1; k <= nodes; k++) {
                    if (
                            allDistances[j][i] != MAX_VALUE && allDistances[i][k] != MAX_VALUE
                                    && allDistances[j][k] > allDistances[j][i] + allDistances[i][k]
                    ) {
                        allDistances[j][k] = allDistances[j][i] + allDistances[i][k];
                    }
                }
            }
        }

        return allDistances;
    }

}
