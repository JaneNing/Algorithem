package com.x5sh1.leetcode;
/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3605/
 */
class GetMaximumInGeneratedArray {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        int[] array = new int[n + 1];
        int result = Integer.MIN_VALUE;
        array[0] = 0;
        array[1] = 1;
        for(int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                array[i] = array[i / 2];
            } else {
                array[i] = array[(i - 1) / 2] + array[(i - 1) / 2 + 1];
            }
            result = result > array[i] ? result : array[i];
        }
        return result;
    }
}