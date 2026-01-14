package array.maximum_subarray;

import common.PrintHelper;

public class Solution {

    public int maxSubArray(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToString(nums));
        }

        int maxSubArray = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum = sum + num;
            if (maxSubArray == Integer.MIN_VALUE || sum > maxSubArray) {
                maxSubArray = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        if (PrintHelper.debug) {
            System.out.println("maxSubArray=" + maxSubArray);
        }

        return maxSubArray;
    }

}
