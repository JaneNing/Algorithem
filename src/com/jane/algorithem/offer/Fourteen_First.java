package com.jane.algorithem.offer;

public class Fourteen_First {

    public int cuttingRope(int n) {
        int res = 1;
        while (n > 6) {
            n -= 3;
            res *= 3;
        }
        if (n == 3) {
            res *= 2;
        } else if (n == 4) {
            res *= 4;
        } else if (n == 5) {
            res *= 6;
        } else if (n == 6) {
            res *= 9;
        }
        return res;
    }
}
