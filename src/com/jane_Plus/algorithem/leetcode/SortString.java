package com.jane_Plus.algorithem.leetcode;


public class SortString {


    public static String sortString_1370(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            nums[(s.charAt(i) - 'a')]++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            int i=0;
            while (i < nums.length) {
                if (nums[i]>0){
                    sb.append((char)( i + 'a'));
                    nums[i]--;
                }
                ++i;
            }
            --i;
            while (i>= 0) {
                if (nums[i]>0){
                    sb.append((char)( i + 'a'));
                    nums[i]--;
                }
                --i;
            }
        }
        return sb.toString();
    }
}
