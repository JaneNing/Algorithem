package com.jane.algorithem.leetcode;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int[] arr = new int[len + 1];
        for (int i = 0; i < len; i++) {
            arr[i + 1] = nums[i];
        }
        for (int i = arr.length / 2; i > 0; i--) {
            adjust(arr, i, arr.length);
        }
        int count = 0;
        while (count != k) {
            count++;
            int tem = arr[arr.length - count];
            arr[arr.length - count] = arr[1];
            arr[1] = tem;
            adjust(arr, 1, arr.length - count);
        }
        return arr[arr.length - k];
    }

    private void adjust(int[] arr, int i, int limit) {
        while (i * 2 < limit) {
            int index = i * 2 + 1 == limit ? i * 2 : (arr[i * 2] < arr[i * 2 + 1] ? i * 2 + 1 : i * 2);
            if (arr[i] > arr[index]) break;
            int tem = arr[i];
            arr[i] = arr[index];
            arr[index] = tem;
            i = index;
        }
    }

//    public int findKthLargest(int[] nums, int k) {
//        int l = 0, r = nums.length - 1, index;
//        k = nums.length - k;
//        while ((index = quickSort(nums, l, r)) != k) {
//            if (index < k) {
//                l = index + 1;
//            } else {
//                r = index - 1;
//            }
//        }
//        return nums[index];
//    }
//
//    private int quickSort(int[] nums, int l, int r) {
//        int base = nums[l];
//        int ll = l + 1, rr = r;
//        while (ll <= rr) {
//            while (ll <= r && nums[ll] <= base) {
//                ll++;
//            }
//            while (rr > l && nums[rr] >= base) {
//                rr--;
//            }
//            if (ll > rr) break;
//            int tem = nums[ll];
//            nums[ll] = nums[rr];
//            nums[rr] = tem;
//        }
//        int tem = nums[l];
//        nums[l] = nums[rr];
//        nums[rr] = tem;
//        return rr;
//    }
}
