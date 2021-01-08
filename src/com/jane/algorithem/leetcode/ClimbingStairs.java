package com.jane.algorithem.leetcode;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 3; i <= n; i++) {
            dp[2] = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[1];
    }
}
