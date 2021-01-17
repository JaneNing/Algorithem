package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfRectanglesThatCanFormTheLargestSquare {

    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> map = new HashMap<>();
        int mm = 0;
        for (int[] rectangle : rectangles) {
            int max = Math.min(rectangle[0], rectangle[1]);
            mm = Math.max(max, mm);
            map.put(max, map.getOrDefault(max, 0) + 1);
        }
        return map.get(mm);
    }
}
