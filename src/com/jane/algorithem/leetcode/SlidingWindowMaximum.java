package com.jane.algorithem.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k - 1; i++) {
            if (deque.isEmpty()) {
                deque.add(nums[i]);
                continue;
            }
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
            if (i - k + 1 >= 0 && nums[i - k + 1] == deque.peekFirst()) {
                deque.pollFirst();
            }
        }
        return res;
    }
}
