package com.jane.algorithem.leetcode;

public class StoneGameVII {

    public int stoneGameVII(int[] stones) {
        int[][] dp = new int[stones.length][stones.length];
        int[][] sum = new int[stones.length][stones.length];
        for (int i = 0; i < stones.length; i++) {
            for (int j = i; j < stones.length; j++) {
                if (j == i) {
                    sum[i][j] = stones[i];
                } else {
                    sum[i][j] = sum[i][j - 1] + stones[j];
                }
            }
        }
        for (int i = 1; i < stones.length; i++) {
            dp[i - 1][i] = Math.max(stones[i - 1], stones[i]);
        }
        for (int i = 2; i < stones.length; i++) {
            for (int j = i; j < stones.length; j++) {
                int i1 = sum[j - i][j - 1];
                int i2 = dp[j - i][j - 1];
                int v1 = i1 - i2;
                int i3 = sum[j - i + 1][j];
                int i4 = dp[j - i + 1][j];
                int v2 = i3 - i4;
                dp[j - i][j] = Math.max(v1, v2);
            }
        }
        return dp[0][stones.length - 1];
    }
}
