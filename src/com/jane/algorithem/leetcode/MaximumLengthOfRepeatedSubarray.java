package com.jane.algorithem.leetcode;

public class MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = (i != 0 && j != 0 ? dp[i - 1][j - 1] : 0) + (nums1[i] == nums2[j] ? 1 : 0);
                } else {
                    dp[i][j] = 0;
                }
                max = Integer.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
