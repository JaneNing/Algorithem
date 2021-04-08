package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursion(new StringBuilder(), n, 0, 0, res);
        return res;
    }

    private void recursion(StringBuilder builder, int n, int count1, int count2, List<String> res) {
        if (count1 == n) {
            if (count2 == n) {
                res.add(builder.toString());
            } else {
                builder.append(")");
                recursion(builder, n, count1, count2 + 1, res);
                builder.deleteCharAt(builder.length() - 1);
            }
            return;
        }
        if (count2 == count1) {
            builder.append("(");
            recursion(builder, n, count1 + 1, count2, res);
            builder.deleteCharAt(builder.length() - 1);
        } else {
            builder.append("(");
            recursion(builder, n, count1 + 1, count2, res);
            builder.deleteCharAt(builder.length() - 1);

            builder.append(")");
            recursion(builder, n, count1, count2 + 1, res);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
