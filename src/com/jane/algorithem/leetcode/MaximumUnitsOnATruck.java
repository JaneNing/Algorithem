package com.jane.algorithem.leetcode;

import java.util.Arrays;

public class MaximumUnitsOnATruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (i1, i2) -> {
            if (i1[1] != i2[1]) {
                return i2[1] - i1[1];
            } else {
                return i1[0] - i2[0];
            }
        });
        int res = 0;
        for (int i = 0; i < boxTypes.length && truckSize != 0; i++) {
            if (truckSize <= boxTypes[i][0]) {
                res += (truckSize * boxTypes[i][1]);
                truckSize = 0;
            } else {
                truckSize -= boxTypes[i][0];
                res += (boxTypes[i][1] * boxTypes[i][0]);
            }
        }
        return res;
    }
}
