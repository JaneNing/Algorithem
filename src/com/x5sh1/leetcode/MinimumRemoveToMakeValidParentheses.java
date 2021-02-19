package com.x5sh1.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3645/
 */
public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] array = s.toCharArray();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char temp = array[i];
            if (temp == ')' || temp == '(') {
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    char stackTemp = array[stack.peek()];
                    if (stackTemp == '(' && temp == ')') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                }
            }
        }
        String result = "";
        for (int i = 0; i < size; i++) {
            if (!stack.contains(i)) {
                result += array[i];
            }
        }
        return result;
    }
}
