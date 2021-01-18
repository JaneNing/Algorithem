package com.x5sh1.leetcode;

import java.util.Arrays;

public class MaxNumerOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                result++;
                left++;
                right--;
            } else if (nums[left] + nums[right] > k) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
