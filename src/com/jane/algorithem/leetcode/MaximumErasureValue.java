package com.jane.algorithem.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {

    public int maximumUniqueSubarray(int[] nums) {
        int l = 0, r = 0, tem = 0, res = 0;
        Set<Integer> set = new HashSet<>();
        while (r < nums.length) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                tem -= nums[l];
                l++;
            }
            set.add(nums[r]);
            tem += nums[r];
            r++;
            res = Math.max(tem, res);
        }
        return res;
    }
}
