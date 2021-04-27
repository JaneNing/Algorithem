package com.jane.algorithem.leetcode;

public class HouseRobber {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length >= 1) {
            dp[0] = nums[0];
        }
        if (nums.length >= 2) {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        if (nums.length >= 3) {
            dp[2] = Math.max(nums[0] + nums[2], nums[1]);
        }
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}
