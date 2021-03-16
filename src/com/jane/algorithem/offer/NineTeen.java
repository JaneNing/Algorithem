package com.jane.algorithem.offer;

public class NineTeen {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = i == 0 ? ' ' : s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (pc == '*') {
                    dp[i][j] = dp[i][j - 2] || ((sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') && i != 0 && dp[i - 1][j]);
                } else if (pc == '.') {
                    dp[i][j] = i != 0 && dp[i - 1][j - 1];
                } else {
                    dp[i][j] = sc == pc && i != 0 && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
