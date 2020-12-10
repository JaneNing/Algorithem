package com.jane.algorithem.leetcode;

public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        int i = 1;
        while (i < arr.length && arr[i - 1] < arr[i]) {
            i++;
        }
        if (i == 1 || i == arr.length || arr[i - 1] == arr[i]) return false;
        while (i < arr.length && arr[i - 1] > arr[i]) {
            i++;
        }
        return i == arr.length;
    }
}
