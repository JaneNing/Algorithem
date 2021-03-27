package com.jane.algorithem.offer;

import java.util.Arrays;

public class SixtyOne {

    public static void main(String[] args) {
        SixtyOne sixtyOne = new SixtyOne();
        sixtyOne.isStraight(new int[]{1, 2, 12, 0, 3});
    }

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int min = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (min == 0) {
                    min = nums[i];
                } else {
                    if (nums[i] == min) {
                        return false;
                    } else if (nums[i] == min + 1) {
                        min++;
                    } else if (nums[i] - min - 1 <= count) {
                        count -= nums[i] - min - 1;
                        min = nums[i];
                    } else {
                        return false;
                    }
                }
            } else {
                count++;
            }
        }
        return true;
    }
}
