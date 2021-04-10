package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        List<int[]> list = new ArrayList<>();
        int start = 0, end = 0;
        boolean flag = false;
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                start = intervals[i][0];
                end = intervals[i][1];
                if ((newInterval[1] >= start && newInterval[1] <= end) || (newInterval[0] <= end && newInterval[0] >= start) ||
                        (newInterval[0] <= start && newInterval[1] >= end)) {
                    start = Math.min(newInterval[0], start);
                    end = Math.max(newInterval[1], end);
                    flag = true;
                }
            } else {
                if ((newInterval[1] >= start && newInterval[1] <= end) || (newInterval[0] <= end && newInterval[0] >= start) ||
                        (newInterval[0] <= start && newInterval[1] >= end)) {
                    start = Math.min(newInterval[0], start);
                    end = Math.max(newInterval[1], end);
                    flag = true;
                }
                if (end >= intervals[i][0]) {
                    end = Math.max(end, intervals[i][1]);
                } else {
                    list.add(new int[]{start, end});
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
            if (i == intervals.length - 1) {
                if ((newInterval[1] >= start && newInterval[1] <= end) || (newInterval[0] <= end && newInterval[0] >= start) ||
                        (newInterval[0] <= start && newInterval[1] >= end)) {
                    start = Math.min(newInterval[0], start);
                    end = Math.max(newInterval[1], end);
                    flag = true;
                }
                list.add(new int[]{start, end});
            }
        }
        if (!flag) {
            list.add(0, new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE});
            list.add(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE});
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i)[1] < newInterval[0] && list.get(i + 1)[0] > newInterval[1]) {
                    list.add(i + 1, newInterval);
                    break;
                }
            }
            list.remove(0);
            list.remove(list.size() - 1);
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
