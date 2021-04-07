package com.jane.algorithem.leetcode;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max((r - l) * Math.min(height[l], height[r]), res);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
