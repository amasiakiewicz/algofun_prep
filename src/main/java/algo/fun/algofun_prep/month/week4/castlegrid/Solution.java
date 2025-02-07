package algo.fun.algofun_prep.month.week4.castlegrid;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private static class Point {
        private static final Map<Direction, Function<Point, Point>> directionToPointTemplate = Map.of(
                Direction.UP, p -> new Point(p.x - 1, p.y),
                Direction.DOWN, p -> new Point(p.x + 1, p.y),
                Direction.LEFT, p -> new Point(p.x, p.y - 1),
                Direction.RIGHT, p -> new Point(p.x, p.y + 1)
        );

        int x;

        int y;

        Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        private Map<Point, Direction> createCandidatePointMap(final Set<Point> openPoints) {
            final EnumSet<Direction> candidateDirections = EnumSet.allOf(Direction.class);

            final Map<Point, Direction> newPointToDirectionMap = candidateDirections
                    .stream()
                    .collect(Collectors.toMap(
                            d -> directionToPointTemplate.get(d).apply(this),
                            d -> d
                    ));

            newPointToDirectionMap.keySet().retainAll(openPoints);

            return newPointToDirectionMap;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static class PointDetail {
        EnumMap<Direction, Integer> directionToDistanceMap;

        private PointDetail(final EnumMap<Direction, Integer> directionToDistanceMap) {
            this.directionToDistanceMap = directionToDistanceMap;
        }

        static PointDetail create() {
            final EnumMap<Direction, Integer> directionToDistanceMap = new EnumMap<>(Map.of(
                    Direction.UP, 1,
                    Direction.DOWN, 1,
                    Direction.LEFT, 1,
                    Direction.RIGHT, 1
            ));
            return new PointDetail(directionToDistanceMap);
        }

        static PointDetail create(final PointDetail pointDetail, final Direction newDirection) {
            final int candidateDistance = pointDetail.getMinDistance() + 1;
            final int oldDistance = pointDetail
                    .directionToDistanceMap
                    .getOrDefault(newDirection, candidateDistance);
            final int newDistance = Math.min(oldDistance, candidateDistance);

            final EnumMap<Direction, Integer> newMap = new EnumMap<>(Direction.class);
            newMap.put(newDirection, newDistance);

            return new PointDetail(newMap);
        }

        int getMinDistance() {
            return directionToDistanceMap
                    .values()
                    .stream()
                    .mapToInt(d -> d)
                    .min()
                    .orElse(0);
        }

        PointDetail merge(final PointDetail pointDetail) {
            final EnumMap<Direction, Integer> newDistanceMap = new EnumMap<>(directionToDistanceMap);

            pointDetail.directionToDistanceMap.forEach((direction, distance) ->
                    newDistanceMap.merge(direction, distance, Math::min)
            );

            return new PointDetail(newDistanceMap);
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final PointDetail that = (PointDetail) o;
            return directionToDistanceMap.equals(that.directionToDistanceMap);
        }

        @Override
        public int hashCode() {
            return Objects.hash(directionToDistanceMap);
        }
    }

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid
     *  2. INTEGER startX
     *  3. INTEGER startY
     *  4. INTEGER goalX
     *  5. INTEGER goalY
     */

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        final Point startingPoint = new Point(startX, startY);

        final Set<Point> openPoints = createOpenPoints(grid);

        final Map<Point, PointDetail> pointToDetailMap = new HashMap<>();
        pointToDetailMap.put(startingPoint, PointDetail.create());

        final Deque<Point> pointsToVisit = new ArrayDeque<>();
        pointsToVisit.offer(startingPoint);

        while (!pointsToVisit.isEmpty()) {
            final Point point = pointsToVisit.poll();

            final Map<Point, Direction> candidatePointToDirection = point.createCandidatePointMap(openPoints);
            candidatePointToDirection.forEach((newPoint, newDirection) -> {
                final PointDetail visitedDetail = pointToDetailMap.get(point);
                final PointDetail candidateNewDetail = PointDetail.create(visitedDetail, newDirection);
                
                final PointDetail previousNewDetail = pointToDetailMap.get(newPoint);
                final PointDetail newDetail = pointToDetailMap.merge(
                        newPoint, candidateNewDetail, PointDetail::merge
                );

                if (!newDetail.equals(previousNewDetail)) {
                    pointsToVisit.offer(newPoint);
                }
            });
        }

        final Point goal = new Point(goalX, goalY);
        return pointToDetailMap.get(goal).getMinDistance();
    }

    private static Set<Point> createOpenPoints(final List<String> grid) {
        final Set<Point> openPoints = new HashSet<>();

        for (int i = 0; i < grid.size(); i++) {
            final String s = grid.get(i);
            for (int j = 0; j < s.length(); j++) {
                final char c = s.charAt(j);

                if (c == '.') {
                    final Point point = new Point(i, j);
                    openPoints.add(point);
                }
            }

        }

        return openPoints;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int startX = Integer.parseInt(firstMultipleInput[0]);

        int startY = Integer.parseInt(firstMultipleInput[1]);

        int goalX = Integer.parseInt(firstMultipleInput[2]);

        int goalY = Integer.parseInt(firstMultipleInput[3]);

        int result = Result.minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
