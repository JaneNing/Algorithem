package com.jane.algorithem.leetcode;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            for (int k = j; k < nums.length; k++) {
                if (k + 1 < nums.length && nums[k] == nums[k + 1]) continue;
                if (k - j >= 1) {
                    nums[i] = nums[j];
                    nums[i + 1] = nums[j + 1];
                    i += 2;
                } else {
                    nums[i] = nums[j];
                    i++;
                }
                j = k + 1;
                break;
            }
        }
        return i;
    }
}
