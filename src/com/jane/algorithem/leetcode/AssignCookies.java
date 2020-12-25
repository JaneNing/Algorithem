package com.jane.algorithem.leetcode;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i = g.length - 1, j = s.length - 1;
        while (i >= 0 && j >= 0) {
            if (g[i] <= s[j]) {
                i--;
                j--;
                res++;
            } else {
                i--;
            }
        }
        return res;
    }
}
