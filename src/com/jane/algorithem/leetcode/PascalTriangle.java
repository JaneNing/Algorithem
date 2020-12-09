package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            lists.add(list);
            list.add(1);
            if (i == 0) continue;
            List<Integer> list1 = lists.get(i - 1);
            for (int j = 1; j < i; j++) {
                list.add(list1.get(j - 1) + list1.get(j));
            }
            list.add(1);
        }
        return lists;
    }
}
