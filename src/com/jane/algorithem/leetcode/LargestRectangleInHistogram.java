package com.jane.algorithem.leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Stack<Integer> stack = new Stack();
        Stack<Integer> index = new Stack();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && stack.peek() >= heights[i]) {
                stack.pop();
                index.pop();
            }
            left[i] = stack.isEmpty() ? -1 : index.peek();
            stack.push(heights[i]);
            index.push(i);
        }
        stack.clear();
        index.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= heights[i]) {
                stack.pop();
                index.pop();
            }
            right[i] = stack.isEmpty() ? len : index.peek();
            stack.push(heights[i]);
            index.push(i);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
}
