package com.jane.algorithem.leetcode;

public class TrappingRainWater {

    public int trap(int[] height) {
        int[] l = new int[height.length];
        int[] r = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            l[i] = Math.max(i == 0 ? 0 : l[i - 1], height[i]);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            r[i] = Math.max(i == height.length - 1 ? 0 : r[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(l[i], r[i]) - height[i];
        }
        return res;
    }
}
