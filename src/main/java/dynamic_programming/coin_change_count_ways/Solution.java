package dynamic_programming.coin_change_count_ways;

import common.PrintHelper;

import java.util.List;
import java.util.Objects;

public class Solution {

    public int coinChange(List<Integer> coins, int sum) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("sum=" + sum + " coins=" + PrintHelper.listToStringWithIndex(coins));
        }

        //return recursion(coins, 0, sum);
        //return memoization(coins, 0, sum, new Integer[coins.size()][sum + 1]);
        return bottomUp(coins, sum);
    }

    private int recursion(List<Integer> coins, int index, int sum) {
        if (sum < 0) {
            return 0;
        } else if (coins.size() == index) {
            return 0;
        } else if (sum == 0) {
            return 1;
        }

        int coin = coins.get(index);
        return recursion(coins, index, sum - coin) // with coin
                + recursion(coins, index + 1, sum); // without coin
    }

    private int memoization(List<Integer> coins, int index, int sum, Integer[][] memo) {
        if (sum < 0) {
            return 0;
        } else if (coins.size() == index) {
            return 0;
        } else if (sum == 0) {
            return 1;
        } else if (Objects.nonNull(memo[index][sum])) {
            return memo[index][sum];
        }

        int coin = coins.get(index);
        memo[index][sum] = memoization(coins, index, sum - coin, memo) // with coin
                + memoization(coins, index + 1, sum, memo); // without coin

        return memo[index][sum];
    }

    private int bottomUp(List<Integer> coins, int sum) {

        Integer[] dp = new Integer[sum + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int s = 1; s <= sum; s++) {
                if (s - coin >= 0) {
                    if (Objects.isNull(dp[s])) {
                        dp[s] = dp[s - coin];
                    } else {
                        dp[s] = dp[s] + dp[s - coin];
                    }
                }
            }
        }

        return Objects.nonNull(dp[sum]) ? dp[sum] : 0;
    }
}
