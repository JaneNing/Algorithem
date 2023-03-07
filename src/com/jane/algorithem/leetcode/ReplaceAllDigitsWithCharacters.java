package com.jane.algorithem.leetcode;

import java.util.Arrays;

public class ReplaceAllDigitsWithCharacters {

    public static void main(String[] args) {
        ReplaceAllDigitsWithCharacters replaceAllDigitsWithCharacters = new ReplaceAllDigitsWithCharacters();
        System.out.println(replaceAllDigitsWithCharacters.replaceDigits("a1c1e1"));
    }

    public String replaceDigits(String s) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            chars[i] = (char) (chars[i - 1] + (chars[i] - '0'));
        }
        StringBuilder builder = new StringBuilder();
        for (char aChar : chars) {
            builder.append(aChar);
        }
        return builder.toString();
    }
}
