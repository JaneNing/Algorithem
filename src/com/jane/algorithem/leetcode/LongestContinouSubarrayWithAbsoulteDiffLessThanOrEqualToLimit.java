package com.jane.algorithem.leetcode;

import java.util.PriorityQueue;

public class LongestContinouSubarrayWithAbsoulteDiffLessThanOrEqualToLimit {

    public int longestSubarray(int[] nums, int limit) {
        int l = 0, r = 0, res = -1;
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> smallHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        while (r < nums.length) {
            int num = nums[r];
            int max = bigHeap.isEmpty() ? num : Math.max(num, bigHeap.peek());
            int min = smallHeap.isEmpty() ? num : Math.min(num, smallHeap.peek());
            if (max - min <= limit) {
                bigHeap.add(num);
                smallHeap.add(num);
                res = Math.max(res, r - l + 1);
                r++;
            } else {
                bigHeap.remove(nums[l]);
                smallHeap.remove(nums[l]);
                l++;
            }
        }
        return res;
    }
}
