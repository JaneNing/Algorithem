package com.jane.algorithem.offer;

public class NineTeen {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    if (i == 0) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    char c1 = i == 0 ? ' ' : s.charAt(i - 1);
                    char c2 = p.charAt(j - 1);
                    if (c2 == '*') {
                        dp[i][j] = dp[i][j - 2] || ((p.charAt(j - 2) == c1 || p.charAt(j - 2) == '.') && i != 0 && dp[i - 1][j]);
                    } else if (c2 == '.') {
                        dp[i][j] = i != 0 && dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = c1 == c2 && dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
