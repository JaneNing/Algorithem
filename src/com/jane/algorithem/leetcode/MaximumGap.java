package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumGap {

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int max = nums[0], min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (max == min) return 0;
        int width = (max - min) / nums.length;
        if (width == 0) width = 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = (nums[i] - min) / width;
            key = key == nums.length ? nums.length - 1 : key;
            List<Integer> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            if (list.isEmpty()) {
                list.add(nums[i]);
                list.add(nums[i]);
            } else {
                list.set(0, Math.min(list.get(0), nums[i]));
                list.set(1, Math.max(list.get(1), nums[i]));
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            List<Integer> list = map.get(i);
            if (list == null || list.isEmpty()) {
                continue;
            }
            Integer minMax = list.get(1);
            while (i < nums.length - 1) {
                List<Integer> list1 = map.get(i + 1);
                if (list1 != null && !list1.isEmpty()) {
                    result = Math.max(result, list1.get(0) - minMax);
                    break;
                }
                i++;
            }
        }
        return result;
    }
}
