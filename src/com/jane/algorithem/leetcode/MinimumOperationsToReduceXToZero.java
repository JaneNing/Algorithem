package com.jane.algorithem.leetcode;

public class MinimumOperationsToReduceXToZero {

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum < x) return -1;
        int l = 0, r = 0, res = -1;
        while (r < nums.length) {
            if (sum > x) {
                sum -= nums[r++];
            } else {
                if (sum == x) {
                    if (res == -1) {
                        res = nums.length - (r - l);
                    } else {
                        res = Math.min(res, nums.length - (r - l));
                    }
                }
                sum += nums[l++];
            }
        }
        if (sum == x) {
            if (res == -1) {
                res = l;
            } else {
                res = Math.min(res, l);
            }
        }
        return res;
    }
}
