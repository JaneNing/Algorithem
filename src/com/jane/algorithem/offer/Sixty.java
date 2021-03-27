package com.jane.algorithem.offer;

public class Sixty {

    public double[] dicesProbability(int n) {
        int[][] dp = new int[n + 1][n * 6 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (i == 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] += j - k >= 0 ? dp[i - 1][j - k] : 0;
                    }
                }
            }
        }
        double[] res = new double[n * 6 - n + 1];
        int base = (int) Math.pow(6, n);
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n][n + i] * 1.0 / base;
        }
        return res;
    }
}
