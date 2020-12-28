package com.jane.algorithem.leetcode;

public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if (k == 0 || length <= 1) return 0;
        k = Math.min(k, length / 2);
        int[][] buy = new int[length][k];
        int[][] sell = new int[length][k];
        int res = 0;
        buy[0][0] = -prices[0];
        for (int i = 1; i < k; i++) {
            buy[0][i] = -10000;
        }
        for (int i = 0; i < k; i++) {
            sell[0][i] = -10000;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < k; j++) {
                if (j != 0 && sell[i - 1][j - 1] == -10000) {
                    buy[i][j] = -10000;
                } else {
                    buy[i][j] = Math.max((j == 0 ? 0 : sell[i - 1][j - 1]) - prices[i], buy[i - 1][j]);
                }
                if (buy[i - 1][j] == -10000) {
                    sell[i][j] = -10000;
                } else {
                    sell[i][j] = Math.max(buy[i - 1][j] + prices[i], sell[i - 1][j]);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            res = Math.max(res, sell[length - 1][i]);
        }
        return res;
    }
}
