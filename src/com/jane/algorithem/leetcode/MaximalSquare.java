package com.jane.algorithem.leetcode;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
            res = Math.max(dp[i][0], res);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] - '0';
            res = Math.max(dp[0][i], res);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                dp[i][j] = matrix[i][j] == '1' ? Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1 : 0;
                res = Math.max(dp[i][j], res);
            }
        }
        return res * res;
    }
}
