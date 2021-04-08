package com.jane.algorithem.leetcode;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (j == nums.length - 1 || nums[j + 1] <= nums[i]) {
                        int tem = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tem;
                        Arrays.sort(nums, i + 1, nums.length);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }
}
