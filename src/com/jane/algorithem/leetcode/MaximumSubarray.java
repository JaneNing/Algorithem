package com.jane.algorithem.leetcode;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, tem = 0;
        for (int i = 0; i < nums.length; i++) {
            tem += nums[i];
            res = Math.max(res, tem);
            if (tem <= 0) {
                tem = 0;
            }
        }
        return res;
    }
}
