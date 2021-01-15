package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {

    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> rawMap = new HashMap();
        Map<Integer, List<Integer>> colMap = new HashMap();
        Map<Integer, Map<Integer, Integer>> map = new HashMap();
        for (int i = 0; i < stones.length; i++) {
            int x = stones[i][0];
            int y = stones[i][1];
            Map<Integer, Integer> temMap = map.computeIfAbsent(x, k -> new HashMap());
            temMap.put(y, x * 10000 + y);
        }
        for (int i = 0; i < stones.length; i++) {
            int x = stones[i][0];
            int y = stones[i][1];
            List<Integer> rawList = rawMap.computeIfAbsent(x, k -> new ArrayList());
            List<Integer> colList = colMap.computeIfAbsent(y, k -> new ArrayList());
            for (int j = 0; j < rawList.size(); j++) {
                union(x, y, x, rawList.get(j), map);
            }
            for (int j = 0; j < colList.size(); j++) {
                union(x, y, colList.get(j), y, map);
            }
            rawList.add(y);
            colList.add(x);
        }
        Set<Integer> group = new HashSet();
        for (int i = 0; i < stones.length; i++) {
            int x = stones[i][0];
            int y = stones[i][1];
            group.add(find(x, y, map));
        }
        return stones.length - group.size();
    }

    private int find(int x, int y, Map<Integer, Map<Integer, Integer>> map) {
        if (x * 10000 + y == map.get(x).get(y)) {
            return x * 10000 + y;
        } else {
            int pa = find(map.get(x).get(y) / 10000, map.get(x).get(y) % 10000, map);
            map.get(x).put(y, pa);
            return pa;
        }
    }

    private void union(int x, int y, int x1, int y1, Map<Integer, Map<Integer, Integer>> map) {
        int px = find(x, y, map);
        int py = find(x1, y1, map);
        map.get(px / 10000).put(px % 10000, map.get(py / 10000).get(py % 10000));
    }
}
