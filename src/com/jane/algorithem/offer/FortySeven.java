package com.jane.algorithem.offer;

public class FortySeven {

    public int maxValue(int[][] grid) {
        int height = grid.length;
        if (height == 0) return 0;
        int width = grid[0].length;
        if (width == 0) return 0;
        int[][] dp = new int[height][width];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[height - 1][width - 1];
    }
}
