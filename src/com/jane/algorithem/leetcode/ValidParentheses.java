package com.jane.algorithem.leetcode;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop == '(') {
                    if (c != ')') {
                        return false;
                    }
                } else if (pop == '[') {
                    if (c != ']') {
                        return false;
                    }
                } else if (pop == '{') {
                    if (c != '}') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
