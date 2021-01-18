package com.x5sh1.leetcodecn;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
 */
class MostStonesRemovedWithSameRowOrColumn {

    public int removeStones(int[][] stones) {
        UnionFindSet set = new UnionFindSet();
        for (int[] stone : stones) {
            set.union(set.find(stone[0] + 10001), set.find(stone[1]));
        }
        return stones.length - set.rootCount;
    }

    private class UnionFindSet {
        private Map<Integer, Integer> roots = new HashMap<>();
        public int rootCount = 0;

        public int find(int num) {
            if (!roots.containsKey(num)) {
                roots.put(num, num);
                rootCount++;
            }

            if (num != roots.get(num)) {
                roots.put(num, find(roots.get(num)));
            }
            return roots.get(num);
        }

        public void union(int a, int b) {
            int rootA = roots.get(a);
            int rootB = roots.get(b);
            if (rootA == rootB) {
                return;
            }

            roots.put(rootA, rootB);
            rootCount--;
        }
    }
}