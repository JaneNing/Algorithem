package com.jane.algorithem.leetcode;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int left, int right) {
        if (right - left <= 0) {
            return;
        }
        int i = left, l = left + 1, r = right;
        while (l <= r) {
            while (l <= right && nums[l] <= nums[i]) {
                l++;
            }
            while (r >= left && nums[r] >= nums[i]) {
                r--;
            }
            if (r < left) {
                break;
            }
            if (l > r) {
                int tem = nums[i];
                nums[i] = nums[r];
                nums[r] = tem;
            } else {
                int tem = nums[l];
                nums[l] = nums[r];
                nums[r] = tem;
            }
        }
        r = r < left ? left : r;
        quickSort(nums, left, r - 1);
        quickSort(nums, r + 1, right);
    }
}
