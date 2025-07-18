package algo.fun.algofun_prep.bonus.cashMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    private static final Set<Integer> availableBanknotes = Set.of(1, 2, 5, 10, 20, 50);

    static List<Integer> cashMachine(int amountToPay, int amountGiven) {
        if (amountGiven < amountToPay) {
            return Collections.emptyList();
        }

        final int amountToGiveBack = amountGiven - amountToPay;
        if (availableBanknotes.contains(amountToGiveBack)) {
            return List.of(amountToGiveBack);
        }

        final Map<Integer, List<Integer>> minBanknotes = availableBanknotes
                .stream()
                .filter(a -> a < amountToGiveBack)
                .collect(Collectors.toMap(a -> a, List::of));

        Set<Integer> visitedAmounts = new HashSet<>(minBanknotes.keySet());

        while (!visitedAmounts.isEmpty()) {

            final Set<Integer> newAmounts = new HashSet<>();

            for (final Integer visitedAmount : visitedAmounts) {
                for (final Integer availableBanknote : availableBanknotes) {
                    final int newAmount = visitedAmount + availableBanknote;
                    if (newAmount > amountToGiveBack) {
                        continue;
                    }

                    final int newAmountSize = minBanknotes
                            .getOrDefault(newAmount, new ArrayList<>())
                            .size();
                    final List<Integer> visitedAmountBanknotes = minBanknotes.get(visitedAmount);
                    if (newAmountSize == 0 || visitedAmountBanknotes.size() + 1 < newAmountSize) {
                        final List<Integer> newAmountBanknotes = new ArrayList<>(visitedAmountBanknotes);
                        newAmountBanknotes.add(availableBanknote);
                        minBanknotes.put(newAmount, newAmountBanknotes);

                        newAmounts.add(newAmount);
                    }
                }
            }

            visitedAmounts = newAmounts;
        }

        return minBanknotes
                .get(amountToGiveBack)
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

}
