package com.jane.algorithem.offer;

public class TwentyOne {

    public int[] exchange(int[] nums) {
        int lIndex = 0, rIndex = nums.length - 1;
        while (lIndex < rIndex) {
            while (lIndex < rIndex && (nums[lIndex] & 1) == 1) {
                lIndex++;
            }
            while ((rIndex > lIndex && ((nums[rIndex] & 1) == 0))) {
                rIndex--;
            }
            if (lIndex >= rIndex) {
                break;
            }
            int tem = nums[lIndex];
            nums[lIndex] = nums[rIndex];
            nums[rIndex] = tem;
        }
        return nums;
    }
}
