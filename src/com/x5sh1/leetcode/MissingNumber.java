package com.x5sh1.leetcode;

/**
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3659/
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int oriSum = 0;
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            if (i < n) {
                sum += nums[i];
            }
            oriSum += i;
        }
        return oriSum - sum;
    }
}
