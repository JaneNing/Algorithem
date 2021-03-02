package com.x5sh1.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3658/
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] buffer = new int[n + 1];
        int[] result = new int[2];
        for (int num : nums) {
            buffer[num]++;
            if (buffer[num] == 2) {
                result[0] = num;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (buffer[i] == 0) {
                result[1] = i;
            }
        }
        return result;
    }
}
