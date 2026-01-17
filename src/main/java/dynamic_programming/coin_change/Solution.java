package dynamic_programming.coin_change;

import common.PrintHelper;

import java.util.Objects;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        //return recursion(coins, amount);
        return memoization(coins, amount, new Integer[amount + 1]);
        //return bottomUp(coins, amount);
    }

    private int recursion(int[] coins, int amount) {
        if (amount < 0) {
            return -1;              // impossible path
        } else if (amount == 0) {
            return 0;               // 0 coins needed
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = recursion(coins, amount - coin);
            if (sub != -1) { // only consider valid results
                min = Math.min(min, sub + 1);
            }
        }

        // if no valid combination found
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    private int memoization(int[] coins, int amount, Integer[] coinChange) {
        if (amount < 0) {
            return -1;
        } else if (amount == 0) {
            return 0;
        } else if (Objects.nonNull(coinChange[amount])) {
            return coinChange[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = memoization(coins, amount - coin, coinChange);
            if (sub != -1) { // only consider valid results
                min = Math.min(min, sub + 1);
            }
        }
        coinChange[amount] = (min == Integer.MAX_VALUE) ? -1 : min;

        // if no valid combination found
        return coinChange[amount];
    }

    private int bottomUp(int[] coins, int amount) {

        Integer[] coinChange = new Integer[amount + 1];
        coinChange[0] = 0;

        for (int a = 1; a <= amount; a++) {
            for (int coin : coins) {
                if (a - coin >= 0 && Objects.nonNull(coinChange[a - coin])) {
                    if (Objects.isNull(coinChange[a])) {
                        coinChange[a] = coinChange[a - coin] + 1;
                    } else {
                        coinChange[a] = Math.min(coinChange[a], coinChange[a - coin] + 1);
                    }
                }
            }
        }
        return Objects.isNull(coinChange[amount]) ? -1 : coinChange[amount];
    }
}
