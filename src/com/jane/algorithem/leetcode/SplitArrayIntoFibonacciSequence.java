package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {

    public List<Integer> splitIntoFibonacci(String S) {
        long[] arr = new long[200];
        int i = 0;
        for (int j = 0; j < (S.startsWith("0") ? 1 : S.length() - 2); j++) {
            arr[i] = Long.parseLong(S.substring(0, j + 1));
            if (arr[i] > Integer.MAX_VALUE) break;
            i++;
            for (int k = j + 1; k < (S.charAt(j + 1) == '0' ? j + 2 : S.length()); k++) {
                arr[i] = Long.parseLong(S.substring(j + 1, k + 1));
                if (arr[i] > Integer.MAX_VALUE) break;
                i++;
                int l = k + 1;
                while (l != S.length()) {
                    long sum = arr[i - 2] + arr[i - 1];
                    if (sum > Integer.MAX_VALUE) break;
                    String s1 = String.valueOf(sum);
                    if (l + s1.length() > S.length()) break;
                    if (S.charAt(l) == '0' && sum != 0) break;
                    String s2 = S.substring(l, l + s1.length());
                    if (!s1.equals(s2)) break;
                    arr[i++] = sum;
                    l += s1.length();
                }
                if (l == S.length() && i > 2) {
                    List<Integer> res = new ArrayList<>();
                    for (int m = 0; m < i; m++) {
                        res.add((int) arr[m]);
                    }
                    return res;
                }
                for (int m = i - 1; m > 0; m--) {
                    arr[m] = 0;
                }
                i = 1;
            }
            i--;
        }
        return new ArrayList<>();
    }
}
