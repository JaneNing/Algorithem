package com.jane.algorithem.leetcode;

import java.util.LinkedList;

public class JumpGameVI {

    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        LinkedList<Integer> queue = new LinkedList();
        LinkedList<Integer> index = new LinkedList();
        dp[0] = nums[0];
        index.add(0);
        queue.add(dp[0]);
        for (int i = 1; i < dp.length; i++) {
            dp[i] = queue.peekFirst() + nums[i];
            if (index.peekFirst() + k == i) {
                queue.pollFirst();
                index.pollFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() <= dp[i]) {
                queue.pollLast();
                index.pollLast();
            }
            queue.add(dp[i]);
            index.add(i);
        }
        return dp[dp.length - 1];
    }
}
