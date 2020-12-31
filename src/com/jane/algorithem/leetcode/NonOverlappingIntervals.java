package com.jane.algorithem.leetcode;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (i1, i2) -> {
            if (i1[0] != i2[0]) {
                return i1[0] - i2[0];
            } else {
                return i1[1] - i2[1];
            }
        });
        int index = 0 , res = 0;
        for(int i = 0 ; i < intervals.length ; i++){
            if(i == 0){
                index = intervals[i][1];
            }else{
                if(intervals[i][0] < index){
                    index = Math.min(index,intervals[i][1]);
                    res++;
                }else{
                    index = intervals[i][1];
                }
            }
        }
        return res;
    }
}
