package com.jane.algorithem.leetcode;

public class DegreeOfArray {

    public int findShortestSubArray(int[] nums) {
        int[][] arr = new int[50000][3];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (arr[num][0] == 0) {
                arr[num][0] = 1;
                arr[num][1] = i;
                arr[num][2] = i;
            } else {
                arr[num][0]++;
                arr[num][2] = i;
            }
        }
        int maxNum = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] > maxNum) {
                maxNum = arr[i][0];
                res = arr[i][2] - arr[i][1] + 1;
            } else if (arr[i][0] == maxNum) {
                res = Math.min(res, arr[i][2] - arr[i][1] + 1);
            }
        }
        return res;
    }
}