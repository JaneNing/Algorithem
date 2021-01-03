package com.jane.algorithem.leetcode;

public class BeautifulArrangement {

    public int countArrangement(int n) {
        boolean[] arr = new boolean[n + 1];
        int[] res = new int[1];
        fun(n, 1, arr, res);
        return res[0];
    }

    private void fun(int n, int i, boolean[] arr, int[] res) {
        if (i == n + 1) {
            res[0]++;
            return;
        }
        for (int j = 1; j <= n; j++) {
            if (arr[j]) continue;
            if (!check(i, j)) continue;
            arr[j] = true;
            fun(n, i + 1, arr, res);
            arr[j] = false;
        }
    }

    private boolean check(int i, int j) {
        return i % j == 0 || j % i == 0;
    }
}
