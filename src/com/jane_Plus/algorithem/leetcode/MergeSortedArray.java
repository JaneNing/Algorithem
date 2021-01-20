package com.jane_Plus.algorithem.leetcode;

public class MergeSortedArray {
    public void merge_88(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        } else if (m == 0) {
            if (n >= 0) {
                System.arraycopy(nums2, 0, nums1, 0, n);
            }
            return;
        }
        int i = m-1, j = n-1, k = m + n-1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        if (i < 0) {
            while (j >= 0) {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
    }
}
