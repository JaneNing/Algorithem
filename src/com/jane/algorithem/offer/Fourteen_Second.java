package com.jane.algorithem.offer;

public class Fourteen_Second {

    public int cuttingRope(int n) {
        long res = 1;
        while (n > 6) {
            n -= 3;
            res *= 3;
            res %= (1e9 + 7);
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
        return (int) (res % (1e9 + 7));
    }
}
