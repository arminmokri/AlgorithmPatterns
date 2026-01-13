package dynamic_programming.combinatorial_partitioning;

import common.PrintHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

    public static int combinatorialPartitioning(Integer r, Integer total) {

        int[] ways = new int[total + 1];
        ways[0] = 1;

        List<Integer> steps = new ArrayList<>(
                Arrays.asList(
                        IntStream.range(1, r + 1).boxed().toArray(Integer[]::new)
                )
        );

        // print
        if (PrintHelper.debug) {
            System.out.println("steps=" + PrintHelper.listToString(steps));
            System.out.println();
        }

        for (int i = 0; i < steps.size(); i++) {

            int step = steps.get(i);

            // print
            if (PrintHelper.debug) {
                System.out.println("i=" + i + " step=" + step);
            }

            for (int j = 0; j < ways.length; j++) {
                if (step <= j) {
                    // Update the ways array
                    int index = j - step;
                    ways[j] = ways[j] + ways[index];

                    // print
                    if (PrintHelper.debug) {
                        System.out.println("j=" + j + " index=" + index + " ways=" + PrintHelper.arrayToString(ways));
                    }
                }
            }

            // print
            if (PrintHelper.debug) {
                System.out.println();
            }
        }

        return ways[total];
    }
}
