package com.jane.algorithem.leetcode;

public class ReorganizeString {

    public String reorganizeString(String S) {
        int[] num = new int[27];
        for (int i = 0; i < S.length(); i++) {
            num[S.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        while (builder.length() != S.length()) {
            char a = '@', b = '@';
            int i1 = 26, i2 = 26;
            for (int i = 0; i < 26; i++) {
                if (num[i] > num[i1]) {
                    b = a;
                    i2 = i1;
                    a = (char) ('a' + i);
                    i1 = i;
                } else if (num[i] > num[i2]) {
                    b = (char) ('a' + i);
                    i2 = i;
                }
            }
            num[i1]--;
            builder.append(a);
            if (b == '@') {
                if (S.length() - builder.length() != 0) {
                    return "";
                }
            } else {
                num[i2]--;
                builder.append(b);
            }
        }
        return builder.toString();
    }
}
