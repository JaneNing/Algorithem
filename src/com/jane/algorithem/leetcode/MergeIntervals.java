package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        int start = 0, end = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                if (end >= intervals[i][0]) {
                    end = Math.max(end, intervals[i][1]);
                } else {
                    list.add(new int[]{start, end});
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
            if (i == intervals.length - 1) {
                list.add(new int[]{start, end});
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            res[i][0] = ints[0];
            res[i][1] = ints[1];
        }
        return res;
    }
}
