package com.jane.algorithem.offer;

public class Sixteen {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        boolean flag = false;
        long nn = n;
        if (nn < 0) {
            flag = true;
            nn = -nn;
        }
        double res = recursion(x, nn);
        return flag ? 1 / res : res;
    }

    private double recursion(double x, long n) {
        if (n == 1) return x;
        double tem = recursion(x, n / 2);
        if ((n & 1) == 1) {
            return x * tem * tem;
        } else {
            return tem * tem;
        }
    }
}
