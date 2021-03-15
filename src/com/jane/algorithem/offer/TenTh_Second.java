package com.jane.algorithem.offer;

public class TenTh_Second {

    public int numWays(int n) {
        if (n == 0) return 1;
        else if (n == 1) return 1;
        long n1 = 1, n2 = 1, n3;
        int count = 1;
        while (count++ != n) {
            n3 = n1 + n2;
            n3 %= 1e9 + 7;
            n1 = n2;
            n2 = n3;
        }
        return (int) n2;
    }
}
