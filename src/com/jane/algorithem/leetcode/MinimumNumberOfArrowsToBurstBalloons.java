package com.jane.algorithem.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        int count = 0;
        Arrays.sort(points, (o1, o2) -> o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
        int end = 0, flag = 0, num = 0;
        for (int i = 0; i < points.length; i++) {
            if (flag == 0) {
                end = points[i][1];
                flag = 1;
                num++;
            } else {
                if (points[i][0] > end) {
                    count++;
                    flag = 0;
                    i--;
                    num = 0;
                } else {
                    if (end > points[i][1]) {
                        end = points[i][1];
                        num++;
                    }
                }
            }
        }
        return count + (num == 0 ? 0 : 1);
    }
}
