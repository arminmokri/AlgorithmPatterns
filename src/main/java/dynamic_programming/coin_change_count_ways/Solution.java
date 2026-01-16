package dynamic_programming.coin_change_count_ways;

import common.PrintHelper;

import java.util.List;

public class Solution {

    public static int coinChange(List<Integer> coins, Integer sum) {

        int[] ways = new int[sum + 1];
        ways[0] = 1;

        // print
        if (PrintHelper.debug) {
            System.out.println("coins=" + PrintHelper.listToStringWithIndex(coins));
            System.out.println();
        }

        for (int i = 0; i < coins.size(); i++) {

            int coin = coins.get(i);

            // print
            if (PrintHelper.debug) {
                System.out.println("i=" + i + " coin=" + coin);
            }

            for (int j = 0; j < ways.length; j++) {
                if (coin <= j) {
                    // Update the ways array
                    int index = j - coin;
                    ways[j] = ways[j] + ways[index];

                    // print
                    if (PrintHelper.debug) {
                        System.out.println("j=" + j + " index=" + index + " ways=" + PrintHelper.arrayToStringWithIndex(ways));
                    }
                }
            }

            // print
            if (PrintHelper.debug) {
                System.out.println();
            }
        }

        return ways[sum];
    }
}
