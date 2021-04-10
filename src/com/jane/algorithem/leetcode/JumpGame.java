package com.jane.algorithem.leetcode;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxLen) break;
            maxLen = Math.max(maxLen, nums[i] + i);
            if (maxLen >= nums.length - 1) return true;
        }
        return false;
    }
}
