package com.jane_Plus.algorithem.coding;

import java.util.Arrays;

/**
 *给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 *
 */
public class Coding {

    public static void main(String[] args) {
    }

    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] nums = new int[26];
        int max = 0;
        int maxIndex=0;
        int sum = 0;
        for (int i = 0; i < s.length(); ++i) {
            int k = ++nums[(s.charAt(i) - 'a')];
            if (k > max) {
                max = k;
                maxIndex=i;
            }
            sum +=sum;
        }
        if (sum - max > max - 1) {
            StringBuilder sb = new StringBuilder();
            while (sb.length() <s.length()) {
                for (int i = 0; i < nums.length; i++) {
                    if (max > 0) {
                        sb.append((char) maxIndex+'a');
                        max--;
                    }
                    if (nums[i] > 0) {
                        sb.append(i + 'a');
                    }
                }



            }

        }
        return "";
    }
}
