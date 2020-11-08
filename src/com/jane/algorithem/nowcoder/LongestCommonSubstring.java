package com.jane.algorithem.nowcoder;

/**
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
 * "1AB2345CD","12345EF"
 * "2345"
 * 长度限定1-5000
 * https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=188&&tqId=36310&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
        System.out.println(longestCommonSubstring.LCS("1AB2345CD", "12345EF"));
        System.out.println(longestCommonSubstring.LCS("12345", "123456"));
    }

    public String LCS(String str1, String str2) {
        int[][] dp = new int[5005][5005];
        int start = 0, len = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(j);
                if (c1 != c2) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = i > 0 && j > 0 ? dp[i - 1][j - 1] + 1 : 1;
                    if (dp[i][j] > len) {
                        len = dp[i][j];
                        start = i - len + 1;
                    }
                }
            }
        }
        return len == 0 ? "-1" : str1.substring(start, start + len);
    }
}
