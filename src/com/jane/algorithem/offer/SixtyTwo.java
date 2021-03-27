package com.jane.algorithem.offer;

public class SixtyTwo {

    public int lastRemaining(int n, int m) {
        int count = 1, index = 0;
        while (count < n) {
            index = (index + m) % (count++ + 1);
        }
        return index;
    }
}
