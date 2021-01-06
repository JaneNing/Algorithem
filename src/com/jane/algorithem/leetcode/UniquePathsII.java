package com.jane.algorithem.leetcode;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[height - 1][width - 1] == 1) return 0;
        int[][] dp = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j];
                } else {
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[height - 1][width - 1];
    }
}
