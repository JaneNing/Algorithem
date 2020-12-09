package com.jane.algorithem.leetcode;

public class MinimumMovesToMakeArrayComplementary {

    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] arr = new int[limit * 2 + 2];
        for (int i = 0; i < (nums.length + 1) / 2; i++) {
            arr[1] += 2;
            arr[limit * 2 + 1] -= 2;
            arr[1 + Math.min(nums[i], nums[n - i - 1])] -= 1;
            arr[limit + Math.max(nums[i], nums[n - i - 1]) + 1] += 1;
            arr[nums[i] + nums[n - i - 1]] -= 1;
            arr[nums[i] + nums[n - i - 1] + 1] += 1;
        }
        int res = Integer.MAX_VALUE;
        int s = 0;
        for (int i = 1; i < limit * 2 + 1; i++) {
            s += arr[i];
            res = Math.min(res, s);
        }
        return res;
    }
}