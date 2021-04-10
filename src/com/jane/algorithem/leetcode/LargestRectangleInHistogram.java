package com.jane.algorithem.leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack1.isEmpty() && heights[stack1.peek()] >= heights[i]) {
                stack1.pop();
            }
            if (stack1.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack1.peek();
            }
            stack1.push(i);
        }
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack2.isEmpty() && heights[stack2.peek()] >= heights[i]) {
                stack2.pop();
            }
            if (stack2.isEmpty()) {
                right[i] = heights.length;
            } else {
                right[i] = stack2.peek();
            }
            stack2.push(i);
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
}
