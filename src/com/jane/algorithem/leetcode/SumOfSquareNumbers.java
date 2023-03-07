package com.jane.algorithem.leetcode;

public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int) Math.sqrt(c);
        while (l <= r) {
            long res = (long) (l * l) + (long) (r * r);
            if (res == c) {
                return true;
            } else if (res < c) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }
}
