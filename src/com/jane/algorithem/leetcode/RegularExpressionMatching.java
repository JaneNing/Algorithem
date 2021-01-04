package com.jane.algorithem.leetcode;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        if (m == 0 && n == 0) {
            return true;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                char pc = p.charAt(i - 1);
                char sc = j == 0 ? ' ' : s.charAt(j - 1);
                if (pc == '*') {
                    dp[j][i] = (dp[j][i - 2] || (j != 0 && dp[j - 1][i] && (sc == p.charAt(i - 2) || p.charAt(i - 2) == '.')));
                } else if (pc == '.') {
                    dp[j][i] = j != 0 && dp[j - 1][i - 1];
                } else {
                    dp[j][i] = j != 0 && (dp[j - 1][i - 1] && sc == pc);
                }
            }
        }
        return dp[m][n];
    }
}
