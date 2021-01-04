package com.jane.algorithem.leetcode;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int length = s.length();
        int[] dp = new int[length];
        int res = 0;
        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                    res = Math.max(res, dp[i]);
                } else if (dp[i - 1] != 0 && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}
