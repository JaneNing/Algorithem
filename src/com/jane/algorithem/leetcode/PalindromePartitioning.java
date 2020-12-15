package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<String> set = new ArrayList();
        List<List<String>> lists = new ArrayList();
        fun(s, 0, set, lists);
        return lists;
    }

    private void fun(String s, int i, List<String> list, List<List<String>> lists) {
        if (i == s.length()) {
            List list1 = new ArrayList(list);
            lists.add(list1);
        }
        for (int j = i; j < s.length(); j++) {
            String s1 = s.substring(i, j + 1);
            if (!judge(s1)) continue;
            list.add(s1);
            fun(s, j + 1, list, lists);
            list.remove(list.size() - 1);
        }
    }

    private boolean judge(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
