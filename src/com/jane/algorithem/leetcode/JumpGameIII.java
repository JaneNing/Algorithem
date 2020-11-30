package com.jane.algorithem.leetcode;

import java.util.concurrent.LinkedBlockingQueue;

public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        boolean[] flag = new boolean[arr.length];
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(start);
        flag[start] = true;
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            if (arr[num] == 0) return true;
            if (num - arr[num] >= 0 && !flag[num - arr[num]]) {
                queue.add(num - arr[num]);
                flag[num - arr[num]] = true;
            }
            if (num + arr[num] < arr.length && !flag[num + arr[num]]) {
                queue.add(num + arr[num]);
                flag[num + arr[num]] = true;
            }
        }
        return false;
    }
}
