package com.jane.algorithem.leetcode;

import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int height = matrix.length;
        if (height == 0) return 0;
        int width = matrix[0].length;
        int[] heights = new int[width];
        int res = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += matrix[i][j] - '0';
                }
            }
            int temRes = fun(heights);
            res = Math.max(res, temRes);
        }
        return res;
    }

    private int fun(int[] heights) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        int len = heights.length;
        int[] arr1 = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack1.isEmpty() && stack1.peek() >= heights[i]) {
                stack1.pop();
                stack2.pop();
            }
            if (stack1.isEmpty()) {
                arr1[i] = 0;
            } else {
                arr1[i] = stack2.peek() + 1;
            }
            stack1.push(heights[i]);
            stack2.push(i);
        }
        stack1.clear();
        stack2.clear();
        int[] arr2 = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!stack1.isEmpty() && stack1.peek() >= heights[i]) {
                stack1.pop();
                stack2.pop();
            }
            if (stack1.isEmpty()) {
                arr2[i] = len;
            } else {
                arr2[i] = stack2.peek();
            }
            stack1.push(heights[i]);
            stack2.push(i);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, (arr2[i] - arr1[i]) * heights[i]);
        }
        return res;
    }
}
