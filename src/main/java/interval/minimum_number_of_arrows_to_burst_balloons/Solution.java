package interval.minimum_number_of_arrows_to_burst_balloons;

import common.PrintHelper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        List<List<Integer>> pointList = Arrays.stream(points)
                .map(point -> List.of(point[0], point[1]))
                .sorted(
                        Comparator.comparing((List<Integer> point) -> point.get(0))
                                .thenComparing(point -> point.get(1))
                )
                .collect(Collectors.toList());

        if (PrintHelper.debug) {
            System.out.println("pointList=" + pointList);
        }

        int arrowShotsCount = 1;
        int endPoint = pointList.size() > 0 ? pointList.get(0).get(1) : 0;

        for (int i = 1; i < pointList.size(); i++) {
            List<Integer> point = pointList.get(i);

            if (endPoint >= point.get(0)) {
                continue;
            } else {
                endPoint = point.get(1);
                arrowShotsCount = arrowShotsCount + 1;
            }
        }

        return arrowShotsCount;
    }

}
