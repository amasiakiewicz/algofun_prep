package algo.fun.algofun_prep.threemonth.week13.jack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'getCost' function below.
     *
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */

    private static class WeightNode {
        int node;
        int weight;

        WeightNode(final int node, final int weight) {
            this.node = node;
            this.weight = weight;
        }

    }

    public static void getCost(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        final int cost = getCostInt(gNodes, gFrom, gTo, gWeight);
        final String output = cost == -1 ? "NO PATH EXISTS" : String.valueOf(cost);

        System.out.println(output);
    }

    static int getCostInt(
            final int gNodes, final List<Integer> gFrom, final List<Integer> gTo, final List<Integer> gWeight
    ) {
        final Map<Integer, Set<WeightNode>> edges = createEdges(gFrom, gTo, gWeight);
        final List<Integer> minCost = createMinCost(gNodes);

        final Set<Integer> fromNodes = new HashSet<>();
        fromNodes.add(1);

        while (!fromNodes.isEmpty()) {

            final Set<Integer> nextFromNodes = new HashSet<>();
            
            for (final Integer fromNode : fromNodes) {
                for (final WeightNode toWeightNode : edges.get(fromNode)) {

                    final int candidateMinCostTo = Math.max(minCost.get(fromNode), toWeightNode.weight);
                    final int toNode = toWeightNode.node;
                    if (candidateMinCostTo < minCost.get(toNode)) {
                        minCost.set(toNode, candidateMinCostTo);
                        nextFromNodes.add(toNode);
                    }

                }
            }

            fromNodes.clear();
            fromNodes.addAll(nextFromNodes);
        }

        final Integer gNodeMinCost = minCost.get(gNodes);
        return gNodeMinCost == Integer.MAX_VALUE ? -1 : gNodeMinCost;
    }

    private static List<Integer> createMinCost(final int gNodes) {
        final List<Integer> minCost = new ArrayList<>(gNodes + 1);

        for (int i = 0; i <= gNodes; i++) {
            minCost.add(Integer.MAX_VALUE);
        }
        
        minCost.set(1, 0);

        return minCost;
    }

    private static Map<Integer, Set<WeightNode>> createEdges(
            final List<Integer> gFrom, final List<Integer> gTo, final List<Integer> gWeight
    ) {
        final Map<Integer, Set<WeightNode>> edges = new HashMap<>();

        for (int i = 0; i < gFrom.size(); i++) {
            final Integer from = gFrom.get(i);
            final Integer to = gTo.get(i);
            final Integer weight = gWeight.get(i);

            final WeightNode weightNodeTo = new WeightNode(to, weight);
            edges.computeIfAbsent(from, f -> new HashSet<>())
                    .add(weightNodeTo);

            final WeightNode weightNodeFrom = new WeightNode(from, weight);
            edges.computeIfAbsent(to, f -> new HashSet<>())
                    .add(weightNodeFrom);
        }

        return edges;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                gFrom.add(Integer.parseInt(gFromToWeight[0]));
                gTo.add(Integer.parseInt(gFromToWeight[1]));
                gWeight.add(Integer.parseInt(gFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.getCost(gNodes, gFrom, gTo, gWeight);

        bufferedReader.close();
    }
}
