package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 10/31/2020
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexValueMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = indexValueMap.get(target - nums[i]);
            if (index != null) {
                return new int[]{index, i};
            }
            indexValueMap.put(nums[i], i);
        }
        return new int[]{};
    }
}