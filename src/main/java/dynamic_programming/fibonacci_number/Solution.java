package dynamic_programming.fibonacci_number;

import common.PrintHelper;

import java.util.Objects;

public class Solution {

    public long fibonacciNumber(int n) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        //return recursion(n);
        //return memoization(n, new Long[n + 1]);
        return bottomUp(n);
    }

    private long recursion(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return recursion(n - 1) + recursion(n - 2);
    }

    private long memoization(int n, Long[] memo) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (Objects.nonNull(memo[n])) {
            return memo[n];
        }

        memo[n] = memoization(n - 1, memo) + memoization(n - 2, memo);
        return memo[n];
    }

    private long bottomUp(int n) {
        Long[] dp = new Long[n + 1];
        dp[0] = 0L;
        if (n >= 1) {
            dp[1] = 1L;
        }

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
