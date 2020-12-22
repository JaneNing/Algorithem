package com.jane.algorithem.leetcode;

import java.util.Arrays;

public class SmallestRangeII {

    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int len = A.length - 1;
        int res = A[len] - A[0];
        for(int i = 0 ; i < len; i++){
            int max = Math.max(A[i] + K , A[len] - K);
            int min = Math.min(A[0] + K, A[i + 1] - K);
            res = Math.min(res , Math.abs(max - min));
        }
        return res;
    }
}
