package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int count = 0;
        Map<String, Integer> emailToIndex = new HashMap();
        Map<String, String> emailToName = new HashMap();
        for (List<String> list : accounts) {
            for (int i = 1; i < list.size(); i++) {
                if (!emailToIndex.containsKey(list.get(i))) {
                    emailToIndex.put(list.get(i), count++);
                    emailToName.put(list.get(i), list.get(0));
                }
            }
        }
        int[] fa = new int[count];
        for (int i = 0; i < count; i++) {
            fa[i] = i;
        }
        for (List<String> list : accounts) {
            int index = emailToIndex.get(list.get(1));
            for (int i = 2; i < list.size(); i++) {
                union(index, emailToIndex.get(list.get(i)), fa);
            }
        }
        Map<Integer, Set<String>> groupMap = new HashMap();
        for (List<String> list : accounts) {
            for (int i = 1; i < list.size(); i++) {
                int pa = find(emailToIndex.get(list.get(i)), fa);
                Set set = groupMap.computeIfAbsent(pa, k -> new HashSet());
                set.add(list.get(i));
            }
        }
        List<List<String>> lists = new ArrayList();
        Iterator<Set<String>> iterator = groupMap.values().iterator();
        while (iterator.hasNext()) {
            Set<String> set = iterator.next();
            List<String> list = new ArrayList(set);
            String name = emailToName.get(list.get(0));
            Collections.sort(list);
            List<String> res = new ArrayList();
            res.add(name);
            res.addAll(list);
            lists.add(res);
        }
        return lists;
    }

    private int find(int i, int[] fa) {
        if (i == fa[i]) return i;
        int pa = find(fa[i], fa);
        fa[i] = pa;
        return pa;
    }

    private void union(int i1, int i2, int[] fa) {
        int p1 = find(i1, fa);
        int p2 = find(i2, fa);
        fa[p2] = p1;
    }
}
