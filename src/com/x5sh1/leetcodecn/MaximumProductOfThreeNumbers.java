package com.x5sh1.leetcodecn;

import java.util.Arrays;

/*
https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[length - 1], nums[length - 3] * nums[length - 2] * nums[length - 1]);
    }
}
