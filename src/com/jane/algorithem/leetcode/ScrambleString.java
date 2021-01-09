package com.jane.algorithem.leetcode;

public class ScrambleString {

    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if (len == 0) return false;
        boolean[][][] dp = new boolean[len + 1][len][len];
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len - i + 1; j++) {
                for (int k = 0; k < len - i + 1; k++) {
                    dp[i][j][k] = s1.substring(j, j + i).equals(s2.substring(k, k + i));
                    if (i != 1) {
                        for (int l = 1; l < i; l++) {
                            dp[i][j][k] = dp[l][j][k + i - l] && dp[i - l][j + l][k];
                            if (dp[i][j][k]) {
                                break;
                            }
                            dp[i][j][k] = dp[l][j][k] && dp[i - l][j + l][k + l];
                            if (dp[i][j][k]) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[len][0][0];
    }
}
