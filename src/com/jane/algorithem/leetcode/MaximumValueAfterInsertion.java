package com.jane.algorithem.leetcode;

public class MaximumValueAfterInsertion {

    public String maxValue(String n, int x) {
        char c = String.valueOf(x).charAt(0);
        StringBuilder builder = new StringBuilder(n);
        if (n.charAt(0) == '-') {
            for (int i = 1; i < builder.length(); i++) {
                if (builder.charAt(i) > c) {
                    builder.insert(i, c);
                    break;
                }
                if (i == builder.length() - 1) {
                    builder.insert(i + 1, c);
                    break;
                }
            }
        } else {
            for (int i = 0; i < builder.length(); i++) {
                if (builder.charAt(i) < c) {
                    builder.insert(i, c);
                    break;
                }
                if (i == builder.length() - 1) {
                    builder.insert(i + 1, c);
                    break;
                }
            }
        }
        return builder.toString();
    }
}
