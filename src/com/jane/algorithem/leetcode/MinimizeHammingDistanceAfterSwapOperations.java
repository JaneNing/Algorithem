package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimizeHammingDistanceAfterSwapOperations {

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int len = source.length;
        int[] fa = new int[len];
        for (int i = 0; i < len; i++) {
            fa[i] = i;
        }
        for (int[] allowedSwap : allowedSwaps) {
            union(allowedSwap[0], allowedSwap[1], fa);
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Map<Integer, Integer> bucketMap = map.computeIfAbsent(source[i], k -> new HashMap<>());
            Integer num = bucketMap.getOrDefault(find(i, fa), 0);
            bucketMap.put(find(i, fa), num + 1);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            int pa = find(i, fa);
            Map<Integer, Integer> bucketMap = map.get(target[i]);
            if (bucketMap == null) {
                res++;
                continue;
            }
            Integer num = bucketMap.get(pa);
            if (num == null || num == 0) {
                res++;
                continue;
            }
            bucketMap.put(pa, num - 1);
        }
        return res;
    }

    private int find(int i, int[] fa) {
        if (fa[i] == i) {
            return i;
        } else {
            int pa = find(fa[i], fa);
            fa[i] = pa;
            return pa;
        }
    }

    private void union(int i, int j, int[] fa) {
        int ip = find(i, fa);
        int jp = find(j, fa);
        fa[jp] = ip;
    }
}
