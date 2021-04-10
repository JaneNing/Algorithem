package com.jane.algorithem.leetcode;

public class SortColors {

    public void sortColors(int[] nums) {
        int num1 = 0, num2 = 0, num3 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[num3++] = 2;
                nums[num2++] = 1;
                nums[num1++] = 0;
            } else if (nums[i] == 1) {
                nums[num3++] = 2;
                nums[num2++] = 1;
            } else {
                nums[num3++] = 2;
            }
        }
    }
}
