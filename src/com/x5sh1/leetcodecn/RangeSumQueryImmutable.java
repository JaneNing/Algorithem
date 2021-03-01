package com.x5sh1.leetcodecn;

/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 */
public class RangeSumQueryImmutable {
    private int[] sum;

    public RangeSumQueryImmutable(int[] nums) {
        int size = nums.length;
        this.sum = new int[size + 1];
        for (int i = 0; i < size; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
