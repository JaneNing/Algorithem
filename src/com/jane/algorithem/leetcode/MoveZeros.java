package com.jane.algorithem.leetcode;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0, j = 0;
        while (i < nums.length && j < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            while (j < nums.length && (j <= i || nums[j] == 0)) {
                j++;
            }
            if (j >= nums.length) break;
            int tem = nums[i];
            nums[i] = nums[j];
            nums[j] = tem;
        }
    }
}
