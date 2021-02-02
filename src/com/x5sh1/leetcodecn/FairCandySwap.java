package com.x5sh1.leetcodecn;

import java.util.Arrays;

/*
https://leetcode-cn.com/problems/fair-candy-swap/
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        int[] result = new int[2];
        for (int numA : A) {
            sumA += numA;
        }
        for (int numB : B) {
            sumB += numB;
        }
        int diff = sumA - sumB;
        Arrays.sort(A);
        Arrays.sort(B);
        int target = sumA - diff / 2;
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < A.length && pointer2 < B.length) {
            int temp = sumA - A[pointer1] + B[pointer2];
            if (temp == target) {
                result[0] = A[pointer1];
                result[1] = B[pointer2];
                break;
            } else if (temp > target) {
                pointer1++;
            } else {
                pointer2++;
            }
        }
        return result;
    }
}
