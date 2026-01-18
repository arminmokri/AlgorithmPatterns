package interval.meeting_rooms;

import common.PrintHelper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    //     def canAttendMeetings(self, intervals: List[List[int]]) -> bool:

    public boolean canAttendMeetings(int[][] intervals) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        List<List<Integer>> newIntervals = Arrays.stream(intervals)
                .map(arr -> List.of(arr[0], arr[1]))
                .sorted(
                        Comparator.comparing((List<Integer> list) -> list.get(0))
                                .thenComparing(list -> list.get(1))
                )
                .collect(Collectors.toList());

        if (PrintHelper.debug) {
            System.out.println("newIntervals=" + newIntervals);
        }

        boolean canAttendMeetings = true;

        List<Integer> lastInterval = newIntervals.size() > 0 ? newIntervals.get(0) : null;

        for (int i = 1; i < newIntervals.size(); i++) {
            List<Integer> interval = newIntervals.get(i);
            if (lastInterval.get(1) > interval.get(0)) {
                canAttendMeetings = false;
                break;
            }
            lastInterval = interval;
        }

        return canAttendMeetings;
    }

}
