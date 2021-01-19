package com.x5sh1.leetcode;

/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3609/
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int x = 0;
        int y = 0;
        int max = 1;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n; i++) {
            int init = 0;
            for (int j = i + 1; j < n; j++) {
                boolean temp = false;
                if (j - init >= 2) {
                    temp = temp || (s.charAt(init) == s.charAt(j) && dp[init + 1][j - 1]);
                } else {
                    temp = temp || s.charAt(init) == s.charAt(j);
                }
                if (temp && j - init + 1 > max) {
                    max = j - init + 1;
                    x = init;
                    y = j;
                }
                dp[init][j] = temp;
                init++;
            }
        }
        return s.substring(x, y + 1);
    }
}
