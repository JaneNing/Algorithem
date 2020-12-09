package com.jane.algorithem.leetcode;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        int res = 0;
        for (int i : time) {
            res += arr[(60 - (i % 60)) % 60];
            arr[i % 60]++;
        }
        return res;
    }
}
