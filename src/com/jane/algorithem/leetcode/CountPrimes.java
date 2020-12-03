package com.jane.algorithem.leetcode;

public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] arr = new boolean[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i]) continue;
            res++;
            for (int j = 2 * i; j < n; j += i) {
                arr[j] = true;
            }
        }
        return res;
    }
}
