package com.jane_Plus.algorithem.coding;

import java.util.Arrays;
import java.util.Stack;

/**
 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。

 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。

 说明: 请尽可能地优化你算法的时间和空间复杂度。

 示例 1:

 输入:
 nums1 = [3, 4, 6, 5]
 nums2 = [9, 1, 2, 5, 8, 3]
 k = 5
 输出:
 [9, 8, 6, 5, 3]
 示例 2:

 输入:
 nums1 = [6, 7]
 nums2 = [6, 0, 4]
 k = 5
 输出:
 [6, 7, 6, 0, 4]
 示例 3:

 输入:
 nums1 = [3, 9]
 nums2 = [8, 9]
 k = 3
 输出:
 [9, 8, 9]
 *
 */
public class Coding {

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 4, 6, 5};
        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
        System.out.println(Arrays.toString(new Coding().algorithm_321(nums1, nums2, 5)));
    }

    public int[] algorithm_321(int[] nums1, int[] nums2, int k) {
        if (k <= 0||k>nums1.length+nums2.length) {
            return null;
        }
        int[] res = new int[k];
        for (int i = 0; i < k && i < nums1.length; i++) {
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
        for (int i = 0; i < nums.length; i++) {
            if (maxNum.isEmpty()) {
                maxNum.push(nums[i]);
            }
            while (!maxNum.isEmpty() && maxNum.peek() < nums[i] && maxNum.size() + nums.length - i > num) {
                maxNum.pop();
            }
            maxNum.push(nums[i]);
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
