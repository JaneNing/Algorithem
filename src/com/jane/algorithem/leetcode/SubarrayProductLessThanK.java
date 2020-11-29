package com.jane.algorithem.leetcode;

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0, tem = 1, res = 0;
        while (right < nums.length) {
            tem *= nums[right];
            if (tem < k) {
                right++;
            } else {
                if (right == left) {
                    left++;
                    right++;
                    tem = 1;
                    continue;
                }
                res += (right - left);
                tem /= nums[left++];
                tem /= nums[right];
            }
        }
        for (int i = 1; i <= right - left; i++) {
            res += i;
        }
        return res;
    }
}
