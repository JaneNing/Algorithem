package com.jane.algorithem.offer;

public class FortyNine {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int c1 = 0, c2 = 0, c3 = 0;
        for (int i = 1; i < n; i++) {
            int num = Math.min(Math.min(dp[c1] * 2, dp[c2] * 3), dp[c3] * 5);
            dp[i] = num;
            if (num == dp[c1] * 2) c1++;
            if (num == dp[c2] * 3) c2++;
            if (num == dp[c3] * 5) c3++;
        }
        return dp[n - 1];
    }
}
