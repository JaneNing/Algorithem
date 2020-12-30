package com.jane.algorithem.leetcode;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int i = 0; i < stones.length; i++) {
            queue.add(stones[i]);
        }
        while (queue.size() > 1) {
            Integer first = queue.poll();
            Integer second = queue.poll();
            int offset = first - second;
            if (offset != 0) {
                queue.add(offset);
            }
        }
        return queue.size() == 0 ? 0 : queue.poll();
    }
}
