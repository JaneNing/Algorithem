package com.x5sh1.leetcode;

/*
https://leetcode.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int result = 0;
        while (n != -0) {
            result ++;
            n &= (n - 1);
        }
        return result;
    }
}
