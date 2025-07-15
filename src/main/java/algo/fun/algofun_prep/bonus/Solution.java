package algo.fun.algofun_prep.bonus;

import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Solution {

    private static class ColRow {
        int column;
        int row;

        ColRow(final int column, final int row) {
            this.column = column;
            this.row = row;
        }
    }

    private static final Function<ColRow, Set<ColRow>> knightMoves = cr -> {
        final Set<ColRow> knightMoves = new HashSet<>();

        knightMoves.add(new ColRow(cr.column + 1, cr.row + 2));
        knightMoves.add(new ColRow(cr.column + 1, cr.row - 2));

        knightMoves.add(new ColRow(cr.column - 1, cr.row + 2));
        knightMoves.add(new ColRow(cr.column - 1, cr.row - 2));

        knightMoves.add(new ColRow(cr.column + 2, cr.row + 1));
        knightMoves.add(new ColRow(cr.column + 2, cr.row - 1));

        knightMoves.add(new ColRow(cr.column - 2, cr.row + 1));
        knightMoves.add(new ColRow(cr.column - 2, cr.row - 1));

        return knightMoves;
    };

    public static List<String> getShortestChessKnightPath(String start, String end) {

        List<String> fromPositions = new ArrayList<>();
        fromPositions.add(start);

        final Map<String, List<String>> minMoves = new HashMap<>();
        minMoves.put(start, new ArrayList<>(fromPositions));

        while (!fromPositions.isEmpty()) {

            final List<String> nextFromPositions = new ArrayList<>();

            for (final String fromPosition : fromPositions) {
                for (final String toPosition : getToPositions(fromPosition)) {

                    final List<String> fromPositionPath = minMoves.get(fromPosition);
                    final List<String> toPositionPath = minMoves.getOrDefault(toPosition, new ArrayList<>());

                    if (toPositionPath.isEmpty() || fromPositionPath.size() + 1 < toPositionPath.size()) {
                        final List<String> newToPositionPath = new ArrayList<>(fromPositionPath);
                        newToPositionPath.add(toPosition);
                        minMoves.put(toPosition, newToPositionPath);
                        nextFromPositions.add(toPosition);
                    }
                }

            }

            fromPositions = nextFromPositions;
        }

        return minMoves.get(end);
    }

    private static Set<String> getToPositions(final String fromPosition) {
        final int column = fromPosition.charAt(0);
        final int row = Integer.parseInt(String.valueOf(fromPosition.charAt(1)));

        return knightMoves.apply(new ColRow(column, row))
                .stream()
                .filter(cr -> cr.column >= 'A' && cr.column <= 'H' && cr.row >= 1 && cr.row <= 8)
                .map(cr -> String.format("%c%d", cr.column, cr.row))
                .collect(toSet());
    }
    
}
