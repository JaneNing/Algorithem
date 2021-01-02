package com.jane.algorithem.leetcode;

public class LongestPalindromicSubString {

    public String longestPalindrome(String s) {
        int start = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    start = l;
                    len = r - l + 1;
                }
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    start = l;
                    len = r - l + 1;
                }
                l--;
                r++;
            }
        }
        return s.substring(start, start + len);
    }

    //dp
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if(len == 1){
//            return s;
//        }
//        int start = 0 , end = 0;
//        int[][] dp = new int[len][len];
//        for(int i = 0 ; i < len ; i++){
//            dp[i][i] = 1;
//            if(dp[i][i] > end - start){
//                start = i;
//                end = i+1;
//            }
//        }
//        for(int i = 0 ; i < len - 1; i++){
//            dp[i][i+1] = s.charAt(i) == s.charAt(i+1) ? 2 : 0;
//            if(dp[i][i+1] > end - start){
//                start = i;
//                end = i + 2;
//            }
//        }
//        for(int i = 2 ; i < len ; i++){
//            for(int j = 0 ; j < len - i ; j++){
//                dp[j][j+i] = s.charAt(j) == s.charAt(j+i) && dp[j+1][j+i-1] != 0 ? dp[j+1][j+i-1] + 2 : 0;
//                if(dp[j][j+i] > end - start){
//                    start = j;
//                    end = j + i + 1;
//                }
//            }
//        }
//        return s.substring(start,end);
//    }
}
