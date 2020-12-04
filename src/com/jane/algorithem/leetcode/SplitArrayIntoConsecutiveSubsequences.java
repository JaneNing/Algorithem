package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map1.getOrDefault(num, 0) == 0) continue;
            if (map2.getOrDefault(num - 1, 0) == 0) {
                if (map1.getOrDefault(num, 0) > 0 &&
                        map1.getOrDefault(num + 1, 0) > 0 &&
                        map1.getOrDefault(num + 2, 0) > 0) {
                    map2.put(num + 2, map2.getOrDefault(num + 2, 0) + 1);
                    map1.put(num, map1.get(num) - 1);
                    map1.put(num + 1, map1.getOrDefault(num + 1,0) - 1);
                    map1.put(num + 2, map1.getOrDefault(num + 2,0) - 1);
                } else {
                    return false;
                }
            } else {
                map1.put(num, map1.get(num) - 1);
                map2.put(num - 1, map2.get(num - 1) - 1);
                map2.put(num, map2.getOrDefault(num, 0) + 1);
            }
        }
        return true;
//        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
//        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                map.put(num, new PriorityQueue<>());
//            }
//            if (map.containsKey(num - 1)) {
//                Integer length = map.get(num - 1).poll();
//                if (map.get(num - 1).isEmpty()) {
//                    map.remove(num - 1);
//                }
//                map.get(num).add(length + 1);
//            } else {
//                map.get(num).add(1);
//            }
//        }
//        AtomicBoolean res = new AtomicBoolean(true);
//        map.forEach((num, queue) -> {
//            while (!queue.isEmpty()) {
//                Integer length = queue.poll();
//                if (length < 3) res.set(false);
//            }
//        });
//        return res.get();
    }
}