package com.jane.algorithem.leetcode;

public class BurstBalloons {

    public int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = (i - 1 >= 0 ? nums[i - 1] : 1) * nums[i] * (i + 1 <= nums.length - 1 ? nums[i + 1] : 1);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j - i; k <= j; k++) {
                    dp[j - i][j] = Math.max(dp[j - i][j], (k > 0 ? dp[j - i][k - 1] : 0) + (k < j ? dp[k + 1][j] : 0) + (j - i - 1 >= 0 ? nums[j - i - 1] : 1) * nums[k] * (j + 1 < nums.length ? nums[j + 1] : 1));
                }
            }
        }
        return dp[0][nums.length - 1];
    }
}
