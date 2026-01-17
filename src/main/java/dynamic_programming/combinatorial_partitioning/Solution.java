package dynamic_programming.combinatorial_partitioning;

import common.PrintHelper;

import java.util.Objects;

public class Solution {

    public long combinatorialPartitioning(int r, int partition) {
        if (PrintHelper.debug) {
            System.out.println();
        }


        //return recursion(r, 1, partition);
        //return memoization(r, 1, partition, new Long[r + 1][partition + 1]);
        return bottomUp(r, partition);
    }

    public long recursion(int r, int start, int partition) {
        if (start > r) {
            return 0;
        } else if (partition < 0) {
            return 0;
        } else if (partition == 0) {
            return 1;
        }

        return recursion(r, start, partition - start) // with start
                + recursion(r, start + 1, partition); // without start
    }

    public long memoization(int r, int start, int partition, Long[][] memo) {
        if (start > r) {
            return 0;
        } else if (partition < 0) {
            return 0;
        } else if (partition == 0) {
            return 1;
        } else if (Objects.nonNull(memo[start][partition])) {
            return memo[start][partition];
        }

        memo[start][partition] = memoization(r, start, partition - start, memo) // with start
                + memoization(r, start + 1, partition, memo); // without start

        return memo[start][partition];
    }

    private long bottomUp(int r, int partition) {

        Long[] dp = new Long[partition + 1];
        dp[0] = 1L;

        for (int start = 1; start <= r; start++) {
            for (int p = 1; p <= partition; p++) {
                if (p - start >= 0) {
                    if (Objects.nonNull(dp[p])) {
                        dp[p] = dp[p] + dp[p - start];
                    } else {
                        dp[p] = +dp[p - start];
                    }

                }
            }
        }

        return Objects.nonNull(dp[partition]) ? dp[partition] : 0;
    }
}
