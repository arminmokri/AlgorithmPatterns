package dynamic_programming.house_robber;

import common.PrintHelper;

import java.util.Objects;

public class Solution {

    public int rob(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        //return recursion(nums, nums.length - 1);
        //return memoization(nums, nums.length - 1, new Integer[nums.length]);
        return bottomUp(nums);
    }

    private int recursion(int[] nums, int index) {
        if (index < 0) {
            return 0;
        } else if (index == 0) {
            return nums[0];
        }

        return Math.max(
                recursion(nums, index - 1),
                recursion(nums, index - 2) + nums[index]
        );
    }

    private int memoization(int[] nums, int index, Integer[] memo) {
        if (index < 0) {
            return 0;
        } else if (index == 0) {
            return nums[0];
        } else if (Objects.nonNull(memo[index])) {
            return memo[index];
        }


        memo[index] = Math.max(
                memoization(nums, index - 1, memo),
                memoization(nums, index - 2, memo) + nums[index]
        );
        return memo[index];
    }

    private int bottomUp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        Integer[] dp = new Integer[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int indexNums = 2; indexNums < nums.length; indexNums++) {
            dp[indexNums] = Math.max(dp[indexNums - 1], dp[indexNums - 2] + nums[indexNums]);
        }

        return dp[nums.length - 1];
    }
}
