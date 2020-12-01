package com.jane.algorithem.leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int leftIndex = searchLeft(nums, 0, nums.length - 1, target);
        int rightIndex = searchRight(nums, 0, nums.length - 1, target);
        return new int[]{leftIndex, rightIndex};
    }

    private int searchLeft(int[] nums, int l, int r, int target) {
        if (l > r) return -1;
        int m = (l + r) / 2;
        if (nums[m] == target) {
            if (m - 1 >= l && nums[m - 1] == target) {
                return searchLeft(nums, l, m - 1, target);
            } else {
                return m;
            }
        } else if (nums[m] < target) {
            return searchLeft(nums, m + 1, r, target);
        } else {
            return searchLeft(nums, l, m - 1, target);
        }
    }

    private int searchRight(int[] nums, int l, int r, int target) {
        if (l > r) return -1;
        int m = (l + r) / 2;
        if (nums[m] == target) {
            if (m + 1 <= r && nums[m + 1] == target) {
                return searchRight(nums, m + 1, r, target);
            } else {
                return m;
            }
        } else if (nums[m] < target) {
            return searchRight(nums, m + 1, r, target);
        } else {
            return searchRight(nums, l, m - 1, target);
        }
    }
}
