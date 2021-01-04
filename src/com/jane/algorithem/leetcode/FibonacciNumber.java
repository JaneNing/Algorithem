package com.jane.algorithem.leetcode;

public class FibonacciNumber {

    public int fib(int n) {
        if(n<=1) return n;
        int[] arr = new int[3];
        arr[1] = 1;
        for (int i = 2; i <=n ; i++) {
            arr[2] = arr[0] + arr[1];
            arr[0] = arr[1];
            arr[1] = arr[2];
        }
        return arr[1];
    }
}