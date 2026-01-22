package interval.non_overlapping_intervals;

import common.PrintHelper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        List<List<Integer>> intervalList =
                Arrays.stream(intervals)
                        .map(arr -> List.of(arr[0], arr[1]))
                        .sorted(
                                Comparator.comparing((List<Integer> interval) -> interval.get(0))
                                        .thenComparing(interval -> interval.get(1))
                        )
                        .collect(Collectors.toList());
        if (PrintHelper.debug) {
            System.out.println("intervalList=" + intervalList);
        }

        int eraseCount = 0;
        int entPoint = intervalList.size() > 0 ? intervalList.get(0).get(1) : 0;

        for (int i = 1; i < intervalList.size(); i++) {
            List<Integer> interval = intervalList.get(i);
            if (interval.get(0) < entPoint) {
                entPoint = Math.min(entPoint, interval.get(1));
                eraseCount = eraseCount + 1;
            } else {
                entPoint = interval.get(1);
            }
        }

        if (PrintHelper.debug) {
            System.out.println("eraseCount=" + eraseCount);
        }

        return eraseCount;
    }

}
