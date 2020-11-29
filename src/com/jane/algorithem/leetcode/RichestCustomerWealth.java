package com.jane.algorithem.leetcode;

public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        if (accounts == null || accounts.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < accounts.length; i++) {
            int tem = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                tem += accounts[i][j];
            }
            res = Math.max(res, tem);
        }
        return res;
    }
}
