package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = lists.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = lists.get(j);
                ArrayList<Integer> list1 = new ArrayList<>(list);
                list1.add(nums[i]);
                lists.add(list1);
            }
        }
        return lists;
    }
}
