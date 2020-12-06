package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            List<Integer> list = map.get(k - num);
            if (list == null || list.isEmpty()) {
                List<Integer> list1 = map.computeIfAbsent(num, a -> new ArrayList<>());
                list1.add(num);
            } else {
                list.remove(0);
                res++;
            }
        }
        return res;
    }
}
