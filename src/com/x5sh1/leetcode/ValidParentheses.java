package com.x5sh1.leetcode;

import java.util.Stack;

/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3610/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                continue;
            }
            if (!stack.isEmpty()) {
                char temp = stack.peek();
                if (s.charAt(i) == ')' && temp == '(') {
                    stack.pop();
                } else if (s.charAt(i) == '}' && temp == '{') {
                    stack.pop();
                } else if (s.charAt(i) == ']' && temp == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
