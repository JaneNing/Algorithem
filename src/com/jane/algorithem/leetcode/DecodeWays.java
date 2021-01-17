package com.jane.algorithem.leetcode;

public class DecodeWays {

    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = judge(s, 0, 1) ? 1 : 0;
        for (int i = 1; i < len; i++) {
            dp[i] = (judge(s, i, i + 1) ? dp[i - 1] : 0) + (judge(s, i - 1, i + 1) ? (i == 1 ? 1 : dp[i - 2]) : 0);
        }
        return dp[len - 1];
    }

    private boolean judge(String s, int i, int j) {
        if (s.charAt(i) == '0') return false;
        int num = Integer.parseInt(s.substring(i, j));
        return num >= 1 && num <= 26;
    }

//    public int numDecodings(String s) {
//        int length = s.length();
//        if (length == 0) return 0;
//        int[] dp = new int[length];
//        dp[length - 1] = s.charAt(length - 1) == '0' ? 0 : 1;
//        for (int i = length - 2; i >= 0; i--) {
//            if (s.charAt(i) != '0') {
//                int num = Integer.parseInt(s.substring(i, i + 2)) <= 26 ? (i + 2 >= length ? 1 : dp[i + 2]) : 0;
//                dp[i] = dp[i + 1] + num;
//            }
//        }
//        return dp[0];
//    }
}
