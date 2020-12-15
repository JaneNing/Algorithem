package com.jane.algorithem.leetcode;

public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return 1;
        else if (nums.length == 2) return nums[0] == nums[1] ? 1 : 2;
        int direction = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                direction = 1;
                break;
            } else if (nums[i] < nums[0]) {
                direction = 0;
                break;
            }
        }
        if (direction == -1) {
            return 1;
        }
        int i = 1, res = 1;
        while (i != nums.length) {
            if (direction == 1) {
                i = findUpSubSequence(nums, i) + 1;
                res++;
                direction = 0;
            } else {
                i = findDownSubSequence(nums, i) + 1;
                res++;
                direction = 1;
            }
        }
        return res;
    }

    private int findUpSubSequence(int[] nums, int i) {
        int index = -1;
        for (int j = i; j < nums.length; j++) {
            if (nums[j - 1] <= nums[j]) {
                index = j;
            } else break;
        }
        return index;
    }

    private int findDownSubSequence(int[] nums, int i) {
        int index = -1;
        for (int j = i; j < nums.length; j++) {
            if (nums[j - 1] >= nums[j]) {
                index = j;
            } else break;
        }
        return index;
    }
}
