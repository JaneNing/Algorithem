package com.jane.algorithem.leetcode;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] array1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            array1[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (--array1[c - 'a'] < 0) return false;
        }
        return true;
    }
}
