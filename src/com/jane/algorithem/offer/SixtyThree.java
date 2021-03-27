package com.jane.algorithem.offer;

public class SixtyThree {

    public int maxProfit(int[] prices) {
        int max = -1, profit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (max < prices[i]) {
                max = prices[i];
            } else {
                profit = Math.max(profit, max - prices[i]);
            }
        }
        return profit;
    }
}
