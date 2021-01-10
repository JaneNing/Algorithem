package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        int[] fa = new int[len];
        for (int i = 0; i < len; i++) {
            fa[i] = i;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.get(nums[i]) != null) continue;
            Integer i1 = map.get(nums[i] - 1);
            if (i1 != null) {
                union(i1, i, fa);
            }
            Integer i2 = map.get(nums[i] + 1);
            if (i2 != null) {
                union(i2, i, fa);
            }
            map.put(nums[i], i);
        }
        int res = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Integer num = countMap.getOrDefault(find(i, fa), 0);
            countMap.put(find(i, fa), num + 1);
            res = Math.max(res, num + 1);
        }
        return res;
    }

    private int find(int x, int[] fa) {
        if (fa[x] == x) return x;
        else {
            int pa = find(fa[x], fa);
            fa[x] = pa;
            return pa;
        }
    }

    private void union(int x, int y, int[] fa) {
        int xp = find(x, fa);
        int yp = find(y, fa);
        fa[xp] = yp;
    }
}
