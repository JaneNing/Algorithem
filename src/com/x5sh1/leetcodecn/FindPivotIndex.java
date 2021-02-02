package com.x5sh1.leetcodecn;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int pointer = 0; pointer < nums.length; pointer++) {
            sum -= nums[pointer];
            int lastIndex = pointer - 1;
            if (lastIndex >= 0) {
                leftSum += nums[lastIndex];
            }
            if (leftSum == sum) {
                return pointer;
            }
        }
        return -1;
    }
}
