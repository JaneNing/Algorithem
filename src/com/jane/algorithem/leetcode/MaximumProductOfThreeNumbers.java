package com.jane.algorithem.leetcode;

public class MaximumProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        int maxFirst, maxSecond, minFirst, minSecond, maxThird;
        maxFirst = Math.max(nums[0], nums[1]);
        maxSecond = Math.min(nums[0], nums[1]);
        maxThird = Math.min(Math.min(nums[0], nums[1]), nums[2]);
        minFirst = Math.min(nums[0], nums[1]);
        minSecond = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= maxFirst) {
                maxThird = maxSecond;
                maxSecond = maxFirst;
                maxFirst = nums[i];
            } else if (nums[i] >= maxSecond) {
                maxThird = maxSecond;
                maxSecond = nums[i];
            } else if (nums[i] > maxThird) {
                maxThird = nums[i];
            }
            if (nums[i] <= minFirst) {
                minSecond = minFirst;
                minFirst = nums[i];
            } else if (nums[i] < minSecond) {
                minSecond = nums[i];
            }
        }
        return Math.max(maxFirst * minFirst * minSecond, maxFirst * maxSecond * maxThird);
    }
}
