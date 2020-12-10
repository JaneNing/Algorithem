package com.jane.algorithem.leetcode;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int[] arr = new int[21];
        for (int bill : bills) {
            if (bill == 5) {
                arr[bill]++;
            } else if (bill == 10) {
                if (arr[5]-- <= 0) return false;
                arr[bill]++;
            } else {
                if (arr[10] == 0) {
                    if (arr[5] < 3) return false;
                    arr[5] -= 3;
                    arr[20]++;
                } else {
                    arr[10]--;
                    if (arr[5] < 1) return false;
                    arr[5]--;
                    arr[20]++;
                }
            }
        }
        return true;
    }
}
