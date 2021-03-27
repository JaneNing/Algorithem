package com.jane.algorithem.offer;

import java.util.ArrayList;
import java.util.List;

public class FiftySeven_Second {

    public int[][] findContinuousSequence(int target) {
        List<int[]> lists = new ArrayList<>();
        int l = 1, r = 1, sum = 0;
        while (r <= (target + 1) / 2 + 1) {
            if (sum == target) {
                int[] arr = new int[r - l];
                for (int i = l; i < r; i++) {
                    arr[i-l] = i;
                }
                lists.add(arr);
                sum -= (l++);
            } else if (sum < target) {
                sum += (r++);
            } else {
                sum -= (l++);
            }
        }
        int[][] res = new int[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            int[] ints = lists.get(i);
            res[i] = ints;
        }
        return res;
    }
}
