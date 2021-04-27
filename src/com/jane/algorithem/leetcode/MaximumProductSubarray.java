package com.jane.algorithem.leetcode;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (index == -1) {
                    index = i;
                } else {
                    arr[index] *= -1;
                    arr[i] *= -1;
                    index = -1;
                }
            } else if (arr[i] == 0) {
                index = -1;
            }
        }
        int res = Integer.MIN_VALUE, tem = 1;
        for (int i = 0; i < arr.length; i++) {
            tem *= arr[i];
            res = Math.max(res, tem);
            if (tem <= 0) {
                tem = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        index = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < 0) {
                if (index == -1) {
                    index = i;
                } else {
                    arr[index] *= -1;
                    arr[i] *= -1;
                    index = -1;
                }
            } else if (arr[i] == 0) {
                index = -1;
            }
        }
        tem = 1;
        for (int i = 0; i < arr.length; i++) {
            tem *= arr[i];
            res = Math.max(res, tem);
            if (tem <= 0) {
                tem = 1;
            }
        }
        return res;
    }
}
