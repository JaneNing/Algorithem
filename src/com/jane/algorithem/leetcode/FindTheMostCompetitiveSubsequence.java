package com.jane.algorithem.leetcode;

import java.util.Stack;

public class FindTheMostCompetitiveSubsequence {

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && stack.peek() > num && i + (k - stack.size()) < nums.length) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(num);
            }
        }
        int[] arr = new int[k];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = stack.pop();
        }
        return arr;
    }

//    public int[] mostCompetitive(int[] nums, int k) {
//        int[] arr = new int[k];
//        int i = -1;
//        for (int j = 0; j < nums.length; j++) {
//            int num = nums[j];
//            while (i != -1 && arr[i] > num && (nums.length - j > (k - i - 1))) {
//                i--;
//            }
//            if (i + 1 == k) continue;
//            arr[++i] = num;
//        }
//        return arr;
//    }
}