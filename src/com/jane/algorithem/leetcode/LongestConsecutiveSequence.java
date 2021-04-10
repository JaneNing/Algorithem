package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(10000);
        for (int num : nums) {
            map.put(num, num);
        }
        for (int num : nums) {
            if (map.get(num - 1) != null) {
                union(map, num, num - 1);
            }
            if (map.get(num + 1) != null) {
                union(map, num, num + 1);
            }
        }
        int res = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) continue;
            int p = find(map, num);
            Integer count = countMap.getOrDefault(p, 0);
            res = Math.max(count + 1, res);
            countMap.put(p, count + 1);
        }
        return res;
    }

    private int find(Map<Integer, Integer> fa, int x) {
        if (fa.get(x) == x) return x;
        int i = find(fa, fa.get(x));
        fa.put(x, i);
        return i;
    }

    private void union(Map<Integer, Integer> fa, int x, int y) {
        int i = find(fa, x);
        int j = find(fa, y);
        fa.put(i, j);
    }
}
