package com.jane.algorithem.offer;

public class FortySix {

    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int t = Integer.parseInt(s.substring(i - 1, i + 1));
            dp[i] = dp[i - 1] + (s.charAt(i - 1) == '0' || t > 25 ? 0 : (i == 1 ? 1 : dp[i - 2]));
        }
        return dp[len - 1];
    }
}
