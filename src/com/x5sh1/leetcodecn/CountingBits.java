package com.x5sh1.leetcodecn;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int sum = 0;
            int temp = i;
            while (temp != 0) {
                sum += temp & 1;
                temp = temp >> 1;
            }
            result[i] = sum;
        }
        return result;
    }
}
