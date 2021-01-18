package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int res = 0;
        for (int num : nums) {
            int count = map.getOrDefault(k - num, 0);
            if (count > 0) {
                map.put(k - num, count - 1);
                res++;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return res;
    }
}
