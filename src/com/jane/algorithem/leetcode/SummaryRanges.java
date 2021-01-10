package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                start = i;
            } else {
                if (nums[i] - nums[i - 1] != 1) {
                    if (start == i - 1) {
                        res.add(nums[start] + "");
                    } else {
                        res.add(nums[start] + "->" + nums[i - 1]);
                    }
                    start = i;
                }
            }
        }
        if (start == nums.length - 1) {
            res.add(nums[start] + "");
        } else {
            res.add(nums[start] + "->" + nums[nums.length - 1]);
        }
        return res;
    }
}
