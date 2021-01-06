package com.jane.algorithem.leetcode;

public class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        int index = 0;
        for (int i = 1; i < arr[arr.length - 1]; i++) {
            if (i == arr[index]) {
                index++;
            } else {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }
        return arr[arr.length - 1] + k;
    }
}
