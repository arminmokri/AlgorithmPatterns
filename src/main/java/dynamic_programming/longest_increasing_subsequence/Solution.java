package dynamic_programming.longest_increasing_subsequence;

import common.PrintHelper;

import java.util.Arrays;
import java.util.Objects;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToStringWithIndex(nums));
        }


        //return recursion(nums, 0, -1);
        //return memoization(nums, 0, -1, new Integer[nums.length][nums.length]);
        return bottomUp(nums);
    }

    private int recursion(int[] nums, int index, int previousIndex) {
        if (index == nums.length) {
            return 0;
        }

        int skip = recursion(nums, index + 1, previousIndex);

        int take = 0;
        if (previousIndex == -1 || nums[index] > nums[previousIndex]) {
            take = recursion(nums, index + 1, index) + 1;
        }

        return Math.max(skip, take);

    }

    private int memoization(int[] nums, int index, int previousIndex, Integer[][] memo) {
        if (index == nums.length) {
            return 0;
        } else if (Objects.nonNull(memo[index][previousIndex + 1])) {
            return memo[index][previousIndex + 1];
        }

        int skip = memoization(nums, index + 1, previousIndex, memo);

        int take = 0;
        if (previousIndex == -1 || nums[index] > nums[previousIndex]) {
            take = memoization(nums, index + 1, index, memo) + 1;
        }
        memo[index][previousIndex + 1] = Math.max(skip, take);

        return memo[index][previousIndex + 1];
    }

    private int bottomUp(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

}
