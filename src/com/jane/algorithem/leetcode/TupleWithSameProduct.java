package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TupleWithSameProduct {

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num = nums[i] * nums[j];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int res = 0;
        Iterator<Integer> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            res += (next * (next - 1) / 2) * 8;
        }
        return res;
    }
}
