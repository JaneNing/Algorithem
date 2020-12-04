package com.jane_Plus.algorithem.leetcode;

import java.util.Stack;

public class MaxNum {
    public int[] algorithm_321(int[] nums1, int[] nums2, int k) {
        if (k <= 0||k>nums1.length+nums2.length) {
            return null;
        }
        int[] res = new int[k];
        for (int i = 0; i <= k && i <= nums1.length; i++) {
            int[] merge = merge(nums1, nums2, k, i);
            if (compare(merge, res,k)>0) {
                res = merge;
            }
        }
        return res;
    }


    private int[] merge(int[] nums1, int[] nums2,int k,int num1) {
        int num2 = k - num1;
        Stack<Integer> maxNum1 = new Stack<>();
        Stack<Integer> maxNum2 = new Stack<>();
        findMax(nums1, num1, maxNum1);
        findMax(nums2, num2, maxNum2);
        int[] res = new int[k];
        while (!maxNum1.isEmpty() && !maxNum2.isEmpty() ) {
            if (maxNum1.peek() < maxNum2.peek()) {
                res[--k] = maxNum1.pop();
            }else {
                res[--k] = maxNum2.pop();
            }
        }
        if (maxNum1.isEmpty()) {
            while (!maxNum2.isEmpty()) {
                res[--k] = maxNum2.pop();
            }
        }else {
            while (!maxNum1.isEmpty()) {
                res[--k] = maxNum1.pop();
            }
        }
        return res;
    }
    private void findMax(int[] nums, int num, Stack<Integer> maxNum) {
        if (num > 0 && nums.length >= num) {

            for (int i = 0; i < nums.length; i++) {
                while (!maxNum.isEmpty() && maxNum.peek() < nums[i] && maxNum.size() + nums.length - i > num) {
                    maxNum.pop();
                }
                if (maxNum.size() < num) {
                    maxNum.push(nums[i]);
                }

            }
        }
    }

    private Integer compare(int[] a, int[] b ,int k) {
        for (int i = 0; i < k; i++) {
            if (a[i] > b[i]) {
                return 1;
            } else if (a[i] < b[i]) {
                return -1;
            }
        }
        return 0;
    }
}
