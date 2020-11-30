package com.jane_Plus.algorithem.coding;

import java.util.Arrays;

/**
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 *
 */
public class Sort {

    public static void main(String[] args) {
        System.out.println(sortString_1370("abcabcaddda"));

    }

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
