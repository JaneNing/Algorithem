package com.jane.algorithem.offer;

public class FortyFour {

    public int findNthDigit(int n) {
        int width = 1;
        long base = 9;
        while (n > base * width) {
            n -= base * width;
            width++;
            base *= 10;
        }
        int num = n / width + (n % width != 0 ? 1 : 0);
        n--;
        n %= width;
        int start = 0;
        while (width != 1) {
            width--;
            start *= 10;
            start += 9;
        }
        start += num;
        return Integer.parseInt(String.valueOf(start).charAt(n) + "");
    }
}
