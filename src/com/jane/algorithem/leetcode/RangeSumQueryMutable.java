package com.jane.algorithem.leetcode;

public class RangeSumQueryMutable {

    int[] sum;
    int[] nums;

    public RangeSumQueryMutable(int[] nums) {
        int len = nums.length;
        this.sum = new int[len * 2];
        this.nums = nums;
        buildTree(0, 0, len - 1);
    }

    public void update(int index, int val) {
        updateVal(0, index, val, 0, nums.length - 1);
    }

    public int sumRange(int left, int right) {
        return sumVal(left, right, 0, nums.length - 1, 0);
    }

    private void buildTree(int index, int l, int r) {
        if (l == r) {
            sum[index] = nums[l];
            return;
        }
        int m = l + (r - l) / 2;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        buildTree(left, l, m);
        buildTree(right, m + 1, r);
        sum[index] = sum[left] + sum[right];
    }

    private void updateVal(int index, int i, int val, int l, int r) {
        if (l == r) {
            sum[index] = val;
            return;
        }
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int m = l + (r - l) / 2;
        if (i <= m) {
            updateVal(left, i, val, l, m);
        } else {
            updateVal(right, i, val, m + 1, r);
        }
        sum[index] = sum[left] + sum[right];
    }

    private int sumVal(int left, int right, int l, int r, int index) {
        if (l >= left && r <= right) {
            return sum[index];
        }
        int m = l + (r - l) / 2;
        int lIndex = index * 2 + 1;
        int rIndex = index * 2 + 2;
        int sum = 0;
        if (left <= m) {
            sum += sumVal(left, right, l, m, lIndex);
        }
        if (right >= m + 1) {
            sum += sumVal(left, right, m + 1, r, rIndex);
        }
        return sum;
    }
}
