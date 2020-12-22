package com.jane.algorithem.leetcode;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(cost[i - 2] + dp[i - 2], cost[i - 1] + dp[i - 1]);
        }
        return Math.min(dp[dp.length - 1] + cost[cost.length - 1], dp[dp.length - 2] + cost[cost.length - 2]);
    }
}
