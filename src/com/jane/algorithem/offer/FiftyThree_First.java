package com.jane.algorithem.offer;

public class FiftyThree_First {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (target == nums[m]) {
                int left = searchLeft(nums, m - 1, target);
                int right = searchRight(nums, m + 1, target);
                return left + right + 1;
            } else if (target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return 0;
    }

    public int searchLeft(int[] nums, int r, int target) {
        int ll = 0, rr = r, m;
        while (ll <= rr) {
            m = ll + (rr - ll) / 2;
            if (target == nums[m]) {
                if (m == 0) return r + 1;
                else if (nums[m - 1] != target) {
                    return r - m + 1;
                } else {
                    rr = m - 1;
                }
            } else if (target < nums[m]) {
                rr = m - 1;
            } else {
                ll = m + 1;
            }
        }
        return 0;
    }

    public int searchRight(int[] nums, int l, int target) {
        int ll = l, rr = nums.length - 1, m;
        while (ll <= rr) {
            m = ll + (rr - ll) / 2;
            if (target == nums[m]) {
                if (m == nums.length - 1) return nums.length - l;
                else if (nums[m + 1] != target) {
                    return m - l + 1;
                } else {
                    ll = m + 1;
                }
            } else if (target < nums[m]) {
                rr = m - 1;
            } else {
                ll = m + 1;
            }
        }
        return 0;
    }
}
