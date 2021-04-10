package com.jane.algorithem.leetcode;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        minimumWindowSubstring.minWindow("ADOBECODEBANC"
                , "ABC");
    }

    public String minWindow(String s, String t) {
        int[] arr1 = new int[200];
        int[] arr2 = new int[200];
        int count1 = 0, count2 = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (arr1[c] == 0) count1++;
            arr1[c]++;
        }
        int l = 0, r = 0, start = -1, end = 0;
        while (r < s.length()) {
            if (count2 < count1) {
                char c = s.charAt(r++);
                if (arr1[c] == 0) continue;
                if (++arr2[c] == arr1[c]) {
                    if (++count2 == count1) {
                        if (start == -1 || (r - l < end - start)) {
                            start = l;
                            end = r;
                        }
                    }
                }
            } else {
                char c = s.charAt(l++);
                if (arr1[c] == 0) continue;
                if (arr2[c]-- == arr1[c]) {
                    if (count2-- == count1) {
                        if (start == -1 || (r - (l - 1) < end - start)) {
                            start = l - 1;
                            end = r;
                        }
                    }
                }
            }
        }
        while (count2 >= count1) {
            char c = s.charAt(l++);
            if (arr1[c] == 0) continue;
            if (arr2[c]-- == arr1[c]) {
                if (count2-- == count1) {
                    if (start == -1 || (r - (l - 1) < end - start)) {
                        start = l - 1;
                        end = r;
                    }
                }
            }
        }
        return start == -1 ? "" : s.substring(start, end);
    }
}
