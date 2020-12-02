package com.jane_Plus.algorithem.leetcode;

import java.util.Arrays;

public class ReorganizeString {

    public String reorganizeString_767(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] nums = new int[26];
        int max = 0;
        int maxIndex=0;
        for (int i = 0; i < s.length(); ++i) {
            int k = ++nums[(s.charAt(i) - 'a')];
            if (k > max) {
                max = k;
                maxIndex=(s.charAt(i) - 'a');
            }
        }
        if (s.length() - max > max - 1) {
            char[] res = new char[s.length()];
            int index =0;
            while (max-- > 0) {
                res[index] = (char)(maxIndex+'a');
                index+=2;
            }
            for (int i = 0; i < nums.length; i++) {
                while (nums[i]-- > 0) {
                    if (index >= s.length()) {
                        index = 1;
                    }
                    res[index] = (char)(i+'a');
                    index += 2;
                }
            }
            return Arrays.toString(res);
        }
        return "";
    }
}
