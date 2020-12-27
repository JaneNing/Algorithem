package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class JumpGameIV {

    public int minJumps(int[] arr) {
        int length = arr.length;
        if (length == 1) return 0;
        int[] res = new int[length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            List<Integer> list = map.computeIfAbsent(arr[i], k -> new ArrayList<>());
            list.add(i);
        }
        while (res[length - 1] == 0) {
            Queue<Integer> temQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                Integer index = ((LinkedList<Integer>) queue).pollFirst();
                if (index - 1 >= 0 && res[index - 1] == 0) {
                    res[index - 1] = res[index] + 1;
                    temQueue.add(index - 1);
                }
                if (index + 1 < length && res[index + 1] == 0) {
                    res[index + 1] = res[index] + 1;
                    temQueue.add(index + 1);
                }
                List<Integer> list = map.get(arr[index]);
                if (list.size() > 1) {
                    for (int i = 0; i < list.size(); i++) {
                        Integer temIndex = list.get(i);
                        if (temIndex.equals(index)) continue;
                        if (res[temIndex] != 0) continue;
                        res[temIndex] = res[index] + 1;
                        temQueue.add(temIndex);
                    }
                }
                list.clear();
            }
            queue = temQueue;
        }
        return res[length - 1];
    }
}
