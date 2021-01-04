package com.jane_Plus.algorithem.leetcode;
import java.util.Arrays;

public class SmallestRangeI {
    public int smallestRangeI908(int[] A, int K) {
        if (A.length <= 1) {
            return 0;
        }
        int max = Arrays.stream(A).max().getAsInt();
        int min  = Arrays.stream(A).min().getAsInt();
        if ((max - min) > 2 * K) {
            return max - min - 2 * K;
        }else {
            return 0;
        }
    }

}
