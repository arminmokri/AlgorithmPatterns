package interval.insert_interval;

import common.PrintHelper;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> insert(List<List<Integer>> intervals, List<Integer> newInterval) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("intervals=" + intervals + " newInterval=" + newInterval);
        }

        List<List<Integer>> newIntervals = new ArrayList<>();

        int index = 0;

        while (
                index < intervals.size()
                        && intervals.get(index).get(1) < newInterval.get(0)
        ) {
            List<Integer> interval = intervals.get(index);
            newIntervals.add(interval);
            index = index + 1;
            if (PrintHelper.debug) {
                System.out.println("before start collision - add interval=" + interval);
            }
        }

        int minNewInterval = newInterval.get(0);
        int maxNewInterval = newInterval.get(1);

        while (
                index < intervals.size()
                        && intervals.get(index).get(0) <= newInterval.get(1)
        ) {
            List<Integer> interval = intervals.get(index);
            minNewInterval = Math.min(minNewInterval, interval.get(0));
            maxNewInterval = Math.max(maxNewInterval, interval.get(1));
            index = index + 1;
            if (PrintHelper.debug) {
                System.out.println("in the collision - add newInterval=" + interval);
            }
        }
        newIntervals.add(List.of(minNewInterval, maxNewInterval));

        while (
                index < intervals.size()
                        && newInterval.get(1) < intervals.get(index).get(0)
        ) {
            List<Integer> interval = intervals.get(index);
            newIntervals.add(interval);
            index = index + 1;
            if (PrintHelper.debug) {
                System.out.println("after collision ends - add interval=" + interval);
            }
        }

        if (PrintHelper.debug) {
            System.out.println("newIntervals=" + newIntervals);
        }

        return newIntervals;
    }

}
