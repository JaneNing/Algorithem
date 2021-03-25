package com.jane.algorithem.offer;

public class FiftyOne {

    public int reversePairs(int[] nums) {
        int[] res = new int[1];
        sort(nums, 0, nums.length - 1, res);
        return res[0];
    }

    private void sort(int[] nums, int l, int r, int[] res) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        sort(nums, l, m, res);
        sort(nums, m + 1, r, res);
        int i = l, j = m + 1;
        while (i <= m && j <= r) {
            if (nums[i] > nums[j]) {
                j++;
            } else {
                res[0] += (j - m - 1);
                i++;
            }
        }
        while (i <= m) {
            i++;
            res[0] += (r - m);
        }
        int[] arr = new int[r - l + 1];
        i = l;
        j = m + 1;
        int index = 0;
        while (index < arr.length) {
            if (i == m + 1) {
                arr[index++] = nums[j++];
            } else if (j == r + 1) {
                arr[index++] = nums[i++];
            } else {
                if (nums[i] < nums[j]) {
                    arr[index++] = nums[i++];
                } else {
                    arr[index++] = nums[j++];
                }
            }
        }
        for (int k = 0; k < arr.length; k++) {
            nums[l + k] = arr[k];
        }
    }
}
