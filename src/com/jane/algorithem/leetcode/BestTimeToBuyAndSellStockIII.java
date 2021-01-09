package com.jane.algorithem.leetcode;

public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] buy = new int[len][2];
        int[][] sell = new int[len][2];
        buy[0][0] = -prices[0];
        buy[0][1] = Integer.MIN_VALUE;
        sell[0][0] = Integer.MIN_VALUE;
        sell[0][1] = Integer.MIN_VALUE;
        for(int i = 1 ; i < len ; i++){
            for(int j = 0 ; j < 2 ; j++){
                if(j == 0){
                    buy[i][j] = Math.max(buy[i-1][j],-prices[i]);
                }else{
                    buy[i][j] = sell[i-1][j-1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : Math.max(sell[i-1][j-1] - prices[i],buy[i-1][j]);
                }
                sell[i][j] = buy[i-1][j] == Integer.MIN_VALUE ? Integer.MIN_VALUE : Math.max(buy[i-1][j] + prices[i],sell[i-1][j]);
            }
        }
        int res = 0;
        for(int i = 0 ; i < 2 ; i++){
            res = Math.max(res,sell[len-1][i]);
        }
        return res;
    }
}
