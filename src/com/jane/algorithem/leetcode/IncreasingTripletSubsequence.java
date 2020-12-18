package com.jane.algorithem.leetcode;

import java.util.Stack;

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int limit = Integer.MAX_VALUE;
        for (int num : nums) {
            if (stack.isEmpty()) {
                stack.push(num);
            } else {
                if (num > limit) return true;
                if (num <= stack.peek()) {
                    if (stack.size() == 1) {
                        stack.pop();
                    } else {
                        limit = Math.min(limit, stack.peek());
                        while (!stack.isEmpty() && stack.peek() >= num) {
                            stack.pop();
                        }
                    }
                }
                stack.push(num);
                if (stack.size() == 3) return true;
            }
        }
        return false;
    }
}
