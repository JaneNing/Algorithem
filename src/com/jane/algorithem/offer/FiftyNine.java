package com.jane.algorithem.offer;

import java.util.Deque;
import java.util.LinkedList;

public class FiftyNine {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        int[] res = new int[nums.length + 1 - k];
        res[0] = deque.peekFirst();
        int index = 1;
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            if (deque.peekFirst() == nums[i - k]) deque.pollFirst();
            res[index++] = deque.peekFirst();
        }
        return res;
    }
}
