package com.x5sh1.leetcodecn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
https://leetcode-cn.com/problems/accounts-merge/
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 0; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (j == 0) {
                    continue;
                }

                if (map.containsKey(mail)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(map.get(mail));
                    temp.add(i);
                    pairs.add(temp);
                }
                map.put(mail, i);
            }
        }


        UnionFindSet set = new UnionFindSet();
        for (List<Integer> pair : pairs) {
            set.union(set.find(pair.get(0)), set.find(pair.get(1)));
        }

        Map<Integer, Set<String>> tempMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int root = set.find(i);
            if (accounts.get(i).size() > 1) {
                tempMap.computeIfAbsent(root, k -> new HashSet<String>()).addAll(accounts.get(i).subList(1, accounts.get(i).size()));
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Integer key : tempMap.keySet()) {
            String name = accounts.get(key).get(0);
            List<String> emailList = new ArrayList<String>(tempMap.get(key));
            emailList.sort(String::compareTo);
            emailList.add(0, name);
            result.add(emailList);
        }

        return result;
    }

    private class UnionFindSet {
        public Map<Integer, Integer> roots = new HashMap<>();
        public int rootCount = 0;

        public int find(int num) {
            if (!roots.containsKey(num)) {
                roots.put(num, num);
                rootCount++;
            }

            if (num != roots.get(num)) {
                roots.put(num, find(roots.get(num)));
            }
            return roots.get(num);
        }

        public void union(int a, int b) {
            int rootA = roots.get(a);
            int rootB = roots.get(b);
            if (rootA == rootB) {
                return;
            }

            roots.put(rootA, rootB);
            rootCount--;
        }
    }
}
