package com.jane.algorithem.leetcode;

import java.util.Arrays;

public class SquaresOfASortedArray {

    private int[] fun(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);
        return arr;
    }
}
