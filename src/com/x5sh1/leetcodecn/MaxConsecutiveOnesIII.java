package com.x5sh1.leetcodecn;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int result = 0;
        int left = 0;
        int leftNum = 0;
        int rightNum = 0;
        int n = A.length;
        for (int right = 0; right < n; right++) {
            rightNum += 1 - A[right];
            while (rightNum - leftNum > K) {
                leftNum += 1 - A[left];
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
