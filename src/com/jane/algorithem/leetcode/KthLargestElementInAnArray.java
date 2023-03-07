package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        kthLargestElementInAnArray.findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5);
    }

    public int findKthLargest(int[] nums, int k) {
        int index, l = 0, r = nums.length - 1;
        while ((index = quickSort(nums, l, r)) != nums.length - k) {
            if (index < nums.length - k) {
                l = index + 1;
            } else {
                r = index - 1;
            }
        }
        return nums[index];
    }

    private int quickSort(int[] nums, int l, int r) {
        if (l >= r) return l;
        int ll = l + 1, rr = r;
        while (ll <= rr) {
            while (ll <= r && nums[ll] <= nums[l]) {
                ll++;
            }
            while (rr >= l && nums[rr] >= nums[l]) {
                rr--;
            }
            if (rr <= ll) break;
            int tem = nums[ll];
            nums[ll] = nums[rr];
            nums[rr] = tem;
        }
        if (rr <= l) return l;
        int tem = nums[l];
        nums[l] = nums[rr];
        nums[rr] = tem;
        return rr;
    }

//    public int findKthLargest(int[] nums, int k) {
//        heapSort(nums);
//        return nums[nums.length - k];
//    }
//
//    private void heapSort(int[] nums) {
//        for (int i = nums.length / 2; i >= 0; i--) {
//            adjust(nums, i, nums.length);
//        }
//        for (int i = nums.length - 1; i > 0; i--) {
//            int tem = nums[0];
//            nums[0] = nums[i];
//            nums[i] = tem;
//            adjust(nums, 0, i);
//        }
//    }
//
//    private void adjust(int[] arr, int index, int r) {
//        while (index * 2 + 1 < r) {
//            if (index * 2 + 2 < r) {
//                int max = Math.max(arr[index * 2 + 1], arr[index * 2 + 2]);
//                if (arr[index] >= max) return;
//                if (arr[index * 2 + 1] < arr[index * 2 + 2]) {
//                    int tem = arr[index];
//                    arr[index] = arr[index * 2 + 2];
//                    arr[index * 2 + 2] = tem;
//                    index = index * 2 + 2;
//                } else {
//                    int tem = arr[index];
//                    arr[index] = arr[index * 2 + 1];
//                    arr[index * 2 + 1] = tem;
//                    index = index * 2 + 1;
//                }
//            } else {
//                if (arr[index] >= arr[index * 2 + 1]) return;
//                int tem = arr[index];
//                arr[index] = arr[index * 2 + 1];
//                arr[index * 2 + 1] = tem;
//                index = index * 2 + 1;
//            }
//        }
//    }

//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue();
//        for (int i = 0; i < k; i++) {
//            queue.add(nums[i]);
//        }
//        for (int i = k; i < nums.length; i++) {
//            if (queue.peek() < nums[i]) {
//                queue.poll();
//                queue.add(nums[i]);
//            }
//        }
//        return queue.peek();
//    }

//    public int findKthLargest(int[] nums, int k) {
//        int len = nums.length;
//        int[] arr = new int[len + 1];
//        for (int i = 0; i < len; i++) {
//            arr[i + 1] = nums[i];
//        }
//        for (int i = arr.length / 2; i > 0; i--) {
//            adjust(arr, i, arr.length);
//        }
//        int count = 0;
//        while (count != k) {
//            count++;
//            int tem = arr[arr.length - count];
//            arr[arr.length - count] = arr[1];
//            arr[1] = tem;
//            adjust(arr, 1, arr.length - count);
//        }
//        return arr[arr.length - k];
//    }
//
//    private void adjust(int[] arr, int i, int limit) {
//        while (i * 2 < limit) {
//            int index = i * 2 + 1 == limit ? i * 2 : (arr[i * 2] < arr[i * 2 + 1] ? i * 2 + 1 : i * 2);
//            if (arr[i] > arr[index]) break;
//            int tem = arr[i];
//            arr[i] = arr[index];
//            arr[index] = tem;
//            i = index;
//        }
//    }

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
