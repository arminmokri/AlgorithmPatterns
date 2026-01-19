package interval.merge_intervals;

import common.PrintHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution {

    public List<List<Integer>> merge(List<List<Integer>> intervals) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        intervals = intervals.stream()
                .sorted(
                        Comparator.comparing((List<Integer> item) -> item.get(0))
                                .thenComparing(item -> item.get(1))
                )
                .collect(Collectors.toList());

        List<List<Integer>> newIntervals = new ArrayList<>();

        List<Integer> previousInterval = intervals.size() > 0 ? intervals.get(0) : null;
        IntervalFunction hasOverlap = (a, b) -> a.get(1) >= b.get(0);

        for (int i = 0; i < intervals.size(); i++) {
            List<Integer> interval = intervals.get(i);
            if (hasOverlap.compare(previousInterval, interval)) {
                previousInterval = List.of(
                        previousInterval.get(0),
                        Math.max(previousInterval.get(1), interval.get(1))
                );
            } else {
                newIntervals.add(previousInterval);
                previousInterval = interval;
            }
        }
        if (Objects.nonNull(previousInterval)) {
            newIntervals.add(previousInterval);
        }

        return newIntervals;
    }

    @FunctionalInterface
    private interface IntervalFunction {
        boolean compare(List<Integer> intervalA, List<Integer> intervalB);
    }
}
