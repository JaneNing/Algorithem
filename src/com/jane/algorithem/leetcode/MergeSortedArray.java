package com.jane.algorithem.leetcode;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        for (int i = 0; i < m; i++) {
            nums1[nums1.length - 1 - i] = nums1[m - i - 1];
            nums1[m - i - 1] = 0;
        }
        int i = nums1.length - m, j = 0, index = 0;
        while (i < nums1.length && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums1[index++] = nums1[i++];
            } else {
                nums1[index++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            nums1[index++] = nums1[i++];
        }
        while (j < nums2.length) {
            nums1[index++] = nums2[j++];
        }
    }
}
