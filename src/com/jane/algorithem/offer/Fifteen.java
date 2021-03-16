package com.jane.algorithem.offer;

public class Fifteen {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1) == 1 ? 1 : 0;
            n = n >>> 1;
        }
        return res;
    }
}
