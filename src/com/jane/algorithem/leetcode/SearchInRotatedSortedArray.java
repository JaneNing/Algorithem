package com.jane.algorithem.leetcode;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int l, int r, int target) {
        if (l > r) return -1;
        int m = l + (r - l) / 2;
        if (nums[m] == target) {
            return m;
        }
        if (nums[m] < nums[nums.length - 1]) {
            if (target < nums[m]) {
                return search(nums, l, m - 1, target);
            } else {
                int res = search(nums, l, m - 1, target);
                if (res != -1) return res;
                res = search(nums, m + 1, r, target);
                return res;
            }
        } else {
            if (target > nums[m]) {
                return search(nums, m + 1, r, target);
            } else {
                int res = search(nums, l, m - 1, target);
                if (res != -1) return res;
                res = search(nums, m + 1, r, target);
                return res;
            }
        }
    }
}
