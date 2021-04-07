package com.jane.algorithem.leetcode;

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private boolean search(int[] nums, int l, int r, int target) {
        if (l > r) return false;
        int m = l + (r - l) / 2;
        if (target == nums[m]) return true;
        if (nums[m] < nums[nums.length - 1]) {
            if (target < nums[m]) {
                return search(nums, l, m - 1, target);
            } else {
                return search(nums, l, m - 1, target) || search(nums, m + 1, r, target);
            }
        } else if (nums[m] > nums[nums.length - 1]) {
            if (target > nums[m]) {
                return search(nums, m + 1, r, target);
            } else {
                return search(nums, l, m - 1, target) || search(nums, m + 1, r, target);
            }
        } else {
            return search(nums, l, m - 1, target) || search(nums, m + 1, r, target);
        }
    }
}
