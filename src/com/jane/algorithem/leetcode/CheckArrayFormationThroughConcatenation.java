package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckArrayFormationThroughConcatenation {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0],pieces[i]);
        }
        int i = 0 ;
        while (i < arr.length){
            int[] ints = map.get(arr[i]);
            if(ints == null){
                break;
            }
            for (int j = 0; j < ints.length; j++) {
                if(ints[j] == arr[i]){
                    i++;
                }
            }
        }
        return i == arr.length;
    }
}
