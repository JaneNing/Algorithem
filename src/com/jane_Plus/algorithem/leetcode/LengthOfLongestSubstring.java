package com.jane_Plus.algorithem.leetcode;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring_3(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int index1 = 0, index2 = 0,max = 0;
        while (index2 < chars.length) {
            int remark =contains(chars, index1, index2);
            if (remark!=-1) {
                if (index2 - index1 > max) {
                    max = index2 - index1;
                }
                index1 = remark+1;
            }
            if (index2==chars.length-1&&index2 - index1+1 > max){
                max = index2-index1+1;
            }
            index2++;
        }
        return max;

    }

    private int contains(char[] chars, int index1, int index2) {
        if (index1 >= index2) {
            return -1;
        }
        for (;index1< index2; index1++) {
            if (chars[index1] == chars[index2]) {
                return index1;
            }
        }
        return -1;
    }
}
