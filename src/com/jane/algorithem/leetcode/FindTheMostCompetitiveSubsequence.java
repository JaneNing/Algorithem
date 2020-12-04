package com.jane.algorithem.leetcode;

public class FindTheMostCompetitiveSubsequence {

    public int[] mostCompetitive(int[] nums, int k) {
        int[] arr = new int[k];
        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            while (i != -1 && arr[i] > num && (nums.length - j > (k - i - 1))) {
                i--;
            }
            if (i + 1 == k) continue;
            arr[++i] = num;
        }
        return arr;
    }
}