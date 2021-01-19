package com.jane.algorithem.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        set.add(0);
        int[] distance = new int[points.length];
        for (int i = 1; i < distance.length; i++) {
            distance[i] = Math.abs(points[i][0] - points[0][0]) + Math.abs(points[i][1] - points[0][1]);
        }
        while (set.size() != points.length) {
            int min = 0, index = 0;
            for (int i = 0; i < points.length; i++) {
                if (set.contains(i)) continue;
                if (min == 0) {
                    index = i;
                    min = distance[i];
                } else if (min > distance[i]) {
                    min = distance[i];
                    index = i;
                }
            }
            set.add(index);
            res += min;
            for (int i = 0; i < points.length; i++) {
                if (set.contains(i)) continue;
                distance[i] = Math.min(distance[i], Math.abs(points[i][0] - points[index][0]) + Math.abs(points[i][1] - points[index][1]));
            }
        }
        return res;
    }
}
