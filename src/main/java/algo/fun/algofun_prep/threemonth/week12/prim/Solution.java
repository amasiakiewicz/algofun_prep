package algo.fun.algofun_prep.threemonth.week12.prim;

import static java.util.Comparator.comparing;
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
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */

    private static class VisitingGraph {
        private final Set<Node> visitedNodes;
        private final Set<Node> allNodes;
        private final Map<Node, Set<Edge>> nodeToEdges;
        private int visitWeight;

        static VisitingGraph create(int n, List<List<Integer>> edges, int start) {
            final Node startNode = new Node(start);
            
            final Set<Node> visitedNodes = new HashSet<>();
            visitedNodes.add(startNode);
            
            final Set<Node> allNodes = new HashSet<>();
            final Map<Node, Set<Edge>> nodeToEdges = new HashMap<>();
            
            for (final List<Integer> edgeAsList : edges) {
                final Integer node1Nr = edgeAsList.get(0);
                final Integer node2Nr = edgeAsList.get(1);
                final Integer weight = edgeAsList.get(2);

                final Node node1 = new Node(node1Nr);
                final Node node2 = new Node(node2Nr);
                allNodes.add(node1);
                allNodes.add(node2);
                
                final Edge edge = new Edge(node1, node2, weight);
                nodeToEdges.computeIfAbsent(node1, node -> new HashSet<>())
                        .add(edge);
                nodeToEdges.computeIfAbsent(node2, node -> new HashSet<>())
                        .add(edge);
            }
            
            return new VisitingGraph(visitedNodes, allNodes, nodeToEdges);
        }

        private VisitingGraph(
                final Set<Node> visitedNodes, final Set<Node> allNodes, final Map<Node, Set<Edge>> nodeToEdges
        ) {
            this.visitedNodes = visitedNodes;
            this.allNodes = allNodes;
            this.nodeToEdges = nodeToEdges;
        }

        boolean nodesToVisitExists() {
            return visitedNodes.size() < allNodes.size();
        }

        Set<Edge> getEdgesToVisit() {
            return nodeToEdges
                    .entrySet()
                    .stream()
                    .filter(entry -> !visitedNodes.contains(entry.getKey()))
                    .flatMap(entry -> entry.getValue().stream())
                    .filter(edge -> edge.visibleFrom(visitedNodes))
                    .collect(Collectors.toSet());
        }

        void visit(final Edge edgeToVisit) {
            visitWeight += edgeToVisit.getWeight();
            visitedNodes.addAll(edgeToVisit.getNodes());
        }
        
        int getVisitWeight() {
            return visitWeight;
        }

    }

    private static class Node {
        private final int number;

        Node(final int number) {
            this.number = number;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Node node = (Node) o;
            return number == node.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }
    }

    private static class Edge {
        private final Node node1;
        private final Node node2;
        private final int weight;

        Edge(final Node node1, final Node node2, final int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

        boolean visibleFrom(final Set<Node> visitedNodes) {
            return visitedNodes.contains(node1) || visitedNodes.contains(node2);
        }

        int getWeight() {
            return weight;
        }

        Set<Node> getNodes() {
            return Set.of(node1, node2);
        }
    }

    public static int prims(int n, List<List<Integer>> edges, int start) {
        final VisitingGraph graph = VisitingGraph.create(n, edges, start);
        
        while (graph.nodesToVisitExists()) {
            final Set<Edge> edgesToVisit = graph.getEdgesToVisit();
            final Edge pickedEdgeToVisit = minWeight(edgesToVisit);
            graph.visit(pickedEdgeToVisit);
        }

        return graph.getVisitWeight();
    }

    private static Edge minWeight(final Set<Edge> edgesToVisit) {
        return edgesToVisit
                .stream()
                .min(comparing(Edge::getWeight))
                .orElseThrow();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
