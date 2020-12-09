package com.jane.algorithem.leetcode;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n != 0; i++) {
            boolean left = i == 0 || flowerbed[i - 1] == 0;
            boolean right = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
            if (left && right && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n == 0;
    }
}
