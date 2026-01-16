package dynamic_programming.climbing_stairs;

import common.PrintHelper;

public class Solution {

    public long climbStairs(int n) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        long[] stairs = new long[n + 1];
        stairs[0] = 1;
        stairs[1] = 1;

        for (int i = 2; i < stairs.length; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }

        return stairs[n];
    }
}
