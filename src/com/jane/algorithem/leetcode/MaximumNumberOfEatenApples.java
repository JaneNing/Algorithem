package com.jane.algorithem.leetcode;

public class MaximumNumberOfEatenApples {

    public int eatenApples(int[] apples, int[] days) {
        int[] arr = new int[40005];
        int num = 0, res = 0, eat = 0;
        for (int day = 0; day < arr.length; day++) {
            if (day < apples.length) {
                num += apples[day];
                arr[days[day] + day] += apples[day];
            }
            if (arr[day] != 0) {
                if (arr[day] <= eat) {
                    eat -= arr[day];
                } else {
                    arr[day] -= eat;
                    eat = 0;
                    num -= arr[day];
                }
            }
            if (num > 0) {
                res++;
                eat++;
                num--;
            }
        }
        return res;
    }
}
