package com.jane_Plus.algorithem.leetcode;

public class PaintingPlan {

    public int paintingPlan_22(int n, int k) {
        if(k == n * n||k==0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i * n + j * n - i * j == k) {
                     res+=C(i,n)*C(j,n);
                }
            }
        }
        return res;
    }

    private int C(int k, int n) {
        if (k == 0) {
            return 1;
        }
        int res = 1;
        for (int i = 0; i <k; i++) {
            res = res*(n-i);
        }
        for (int i = 1; i <= k; i++) {
            res = res/i;
        }
        return res;
    }
}
