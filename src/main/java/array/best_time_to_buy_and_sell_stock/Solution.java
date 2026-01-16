package array.best_time_to_buy_and_sell_stock;

import common.PrintHelper;

public class Solution {

    public int maxProfit(int[] prices) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("prices=" + PrintHelper.arrayToStringWithIndex(prices));
        }

        int maxProfit = 0;
        int minBuyPrice = prices.length > 0 ? prices[0] : 0;

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            minBuyPrice = Integer.min(minBuyPrice, price);
            maxProfit = Integer.max(maxProfit, price - minBuyPrice);
        }

        return maxProfit;
    }
}
