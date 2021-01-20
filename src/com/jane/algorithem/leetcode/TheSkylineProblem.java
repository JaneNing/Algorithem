package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1);
        int[][] points = new int[buildings.length * 2][3];
        int index = 0;
        for (int i = 0; i < buildings.length; i++) {
            points[index][0] = buildings[i][0];
            points[index][1] = buildings[i][2];
            points[index++][2] = 0;
            points[index][0] = buildings[i][1];
            points[index][1] = buildings[i][2];
            points[index++][2] = 1;
        }
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else if (o1[2] != o2[2]) {
                return o1[2] - o2[2];
            } else if (o1[2] == 0) {
                return o2[1] - o1[1];
            } else {
                return o1[1] - o2[1];
            }
        });
        int lastHeight = 0, lastIndex = -1;
        queue.add(lastHeight);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            if (points[i][2] == 0) {
                if (lastHeight < points[i][1] && points[i][0] != lastIndex) {
                    lastIndex = points[i][0];
                    lastHeight = points[i][1];
                    List<Integer> list = new ArrayList<>();
                    list.add(points[i][0]);
                    list.add(points[i][1]);
                    lists.add(list);
                }
                queue.add(points[i][1]);
            } else {
                queue.remove(points[i][1]);
                if (queue.peek() < lastHeight && lastIndex != points[i][0]) {
                    lastIndex = points[i][0];
                    lastHeight = queue.peek();
                    List<Integer> list = new ArrayList<>();
                    list.add(points[i][0]);
                    list.add(queue.peek());
                    lists.add(list);
                }
            }
        }
        return lists;
    }
}
