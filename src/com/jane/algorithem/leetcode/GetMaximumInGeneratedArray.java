package com.jane.algorithem.leetcode;

public class GetMaximumInGeneratedArray {

    public int getMaximumGenerated(int n) {
        if (n <= 1) return n;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 0) {
                arr[i] = arr[i / 2];
            } else {
                arr[i] = arr[i / 2] + arr[i / 2 + 1];
            }
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res = Math.max(res, arr[i]);
        }
        return res;
    }
}
