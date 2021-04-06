package com.jane.algorithem.leetcode;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            for (int k = j + 1; k <= nums.length; k++) {
                if (k < nums.length && nums[k] == nums[j]) {
                    continue;
                }
                if (k - j >= 2) {
                    nums[i] = nums[i + 1] = nums[j];
                    i += 2;
                } else {
                    nums[i] = nums[j];
                    i++;
                }
                j = k;
                break;
            }
        }
        return i;
    }
}
