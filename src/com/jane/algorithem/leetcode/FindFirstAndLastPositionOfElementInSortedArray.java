package com.jane.algorithem.leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                int left = searchLeft(nums, l, m, target);
                int right = searchRight(nums, m, r, target);
                return new int[]{left, right};
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return new int[]{-1, -1};
    }

    private int searchLeft(int[] nums, int l, int r, int target) {
        int m;
        int ll = l, rr = r;
        while (ll <= rr) {
            m = ll + (rr - ll) / 2;
            if (nums[m] == target) {
                if (m != l && nums[m - 1] == target) {
                    rr = m - 1;
                } else {
                    return m;
                }
            } else if (nums[m] < target) {
                ll = m + 1;
            } else {
                rr = m - 1;
            }
        }
        return r;
    }

    private int searchRight(int[] nums, int l, int r, int target) {
        int m;
        int ll = l, rr = r;
        while (ll <= rr) {
            m = ll + (rr - ll) / 2;
            if (nums[m] == target) {
                if (m != r && nums[m + 1] == target) {
                    ll = m + 1;
                } else {
                    return m;
                }
            } else if (nums[m] < target) {
                ll = m + 1;
            } else {
                rr = m - 1;
            }
        }
        return l;
    }
}
