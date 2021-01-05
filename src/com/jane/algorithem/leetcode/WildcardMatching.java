package com.jane.algorithem.leetcode;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        if (sl == 0 && pl == 0) return true;
        if (sl != 0 && pl == 0) return false;
        boolean[][] dp = new boolean[sl + 1][pl + 1];
        dp[0][0] = true;
        for (int i = 0; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                char sc = i == 0 ? ' ' : s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (pc == '*') {
                    dp[i][j] = dp[i][j - 1] || (i != 0 && dp[i - 1][j]);
                } else if (pc == '?') {
                    dp[i][j] = i != 0 && dp[i - 1][j - 1];
                } else {
                    dp[i][j] = i != 0 && dp[i - 1][j - 1] && sc == pc;
                }
            }
        }
        return dp[sl][pl];
    }
}
