package com.jane.algorithem.leetcode;

public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--arr[t.charAt(i) - 'a'] == -1) return t.charAt(i);
        }
        return 'a';
    }
}
