package com.jane.algorithem.leetcode;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) return 0;
        int[][] dp = new int[2][prices.length];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0][i] = Math.max(dp[1][i - 1] - prices[i], dp[0][i - 1]);
            if (prices[i] - fee + dp[0][i - 1] > dp[1][i - 1]) {
                dp[1][i] = prices[i] - fee + dp[0][i - 1];
                if (i != prices.length - 1) dp[1][i + 1] = prices[i] - fee + dp[0][i - 1];
            } else {
                dp[1][i] = dp[1][i - 1];
            }
        }
        return dp[1][prices.length - 1];
    }
}
