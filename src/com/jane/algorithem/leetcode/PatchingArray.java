package com.jane.algorithem.leetcode;

public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        long sum = 0;
        int index = 0, num = 0, len = nums.length;
        while (sum < n) {
            if (index >= len || nums[index] > sum + 1) {
                sum += (sum + 1);
                num++;
            } else {
                sum += nums[index++];
            }
        }
        return num;
    }
}
