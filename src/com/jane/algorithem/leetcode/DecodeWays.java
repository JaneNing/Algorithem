package com.jane.algorithem.leetcode;

public class DecodeWays {

    public int numDecodings(String s) {
        int length = s.length();
        if (length == 0) return 0;
        int[] dp = new int[length];
        dp[length - 1] = s.charAt(length - 1) == '0' ? 0 : 1;
        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                int num = Integer.parseInt(s.substring(i, i + 2)) <= 26 ? (i + 2 >= length ? 1 : dp[i + 2]) : 0;
                dp[i] = dp[i + 1] + num;
            }
        }
        return dp[0];
    }
}
