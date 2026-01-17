package dynamic_programming.coin_change;

import common.PrintHelper;

import java.util.Arrays;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        //return recursion(coins, amount);
        //return memoization(coins, amount, new int[amount + 1]);
        return bottomUp(coins, amount);
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

    private int memoization(int[] coins, int amount, int[] coinChange) {
        if (amount < 0) {
            return -1;
        }

        if (coinChange[amount] != 0) {
            return coinChange[amount];
        }

        int result;
        if (amount == 0) {
            result = 0;
        } else {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {

                int sub = memoization(coins, amount - coin, coinChange);
                if (sub != -1) { // only consider valid results
                    min = Math.min(min, sub + 1);
                }
            }
            result = (min == Integer.MAX_VALUE) ? -1 : min;
        }
        coinChange[amount] = result;

        // if no valid combination found
        return result;
    }

    private int bottomUp(int[] coins, int amount) {

        int[] coinChange = new int[amount + 1];
        Arrays.fill(coinChange, Integer.MAX_VALUE);
        coinChange[0] = 0;

        for (int a = 1; a <= amount; a++) {
            for (int coin : coins) {
                if (a - coin >= 0 && coinChange[a - coin] != Integer.MAX_VALUE) {
                    coinChange[a] = Math.min(coinChange[a], coinChange[a - coin] + 1);
                }
            }
        }

        return coinChange[amount] == Integer.MAX_VALUE ? -1 : coinChange[amount];
    }
}
