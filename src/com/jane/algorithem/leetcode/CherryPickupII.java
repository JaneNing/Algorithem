package com.jane.algorithem.leetcode;

public class CherryPickupII {

    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        dp[0][0][grid[0].length - 1] = grid[0][0] + grid[0][grid[0].length - 1];
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < grid[0].length && j <= i; j++) {
                for (int k = grid[0].length - 1; k >= 0 && k >= grid[0].length - 1 - i; k--) {
                    int max = 0;
                    max = Math.max(max, j == 0 || k == 0 ? 0 : dp[i - 1][j - 1][k - 1]);
                    max = Math.max(max, j == 0 ? 0 : dp[i - 1][j - 1][k]);
                    max = Math.max(max, j == 0 || k == grid[0].length - 1 ? 0 : dp[i - 1][j - 1][k + 1]);
                    max = Math.max(max, k == 0 ? 0 : dp[i - 1][j][k - 1]);
                    max = Math.max(max, dp[i - 1][j][k]);
                    max = Math.max(max, k == grid[0].length - 1 ? 0 : dp[i - 1][j][k + 1]);
                    max = Math.max(max, j == grid[0].length - 1 || k == 0 ? 0 : dp[i - 1][j + 1][k - 1]);
                    max = Math.max(max, j == grid[0].length - 1 ? 0 : dp[i - 1][j + 1][k]);
                    max = Math.max(max, j == grid[0].length - 1 || k == grid[0].length - 1 ? 0 : dp[i - 1][j + 1][k + 1]);
                    dp[i][j][k] = max + grid[i][j] + (j == k ? 0 : grid[i][k]);
                    if (i == dp.length - 1) res = Math.max(res, dp[i][j][k]);
                }
            }
        }
        return res;
    }
}
