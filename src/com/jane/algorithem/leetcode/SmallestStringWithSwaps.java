package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Map<Integer, Integer> map = new HashMap();
        int len = s.length();
        int[] fa = new int[len];
        for (int i = 0; i < len; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < pairs.size(); i++) {
            List<Integer> list = pairs.get(i);
            union(list.get(0), list.get(1), fa);
        }
        Map<Integer, List<Character>> sortMap = new HashMap();
        for (int i = 0; i < len; i++) {
            int bucket = find(i, fa);
            List<Character> list = sortMap.computeIfAbsent(bucket, k -> new ArrayList());
            list.add(s.charAt(i));
        }
        Iterator<List<Character>> iterator = sortMap.values().iterator();
        while (iterator.hasNext()) {
            List<Character> list = iterator.next();
            Collections.sort(list);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int bucket = find(i, fa);
            Integer index = map.getOrDefault(bucket, 0);
            builder.append(sortMap.get(bucket).get(index));
            map.put(bucket, index + 1);
        }
        return builder.toString();
    }

    private int find(int x, int[] fa) {
        if (fa[x] == x) return x;
        else {
            int pa = find(fa[x], fa);
            fa[x] = pa;
            return pa;
        }
    }

    private void union(int x, int y, int[] fa) {
        int xp = find(x, fa);
        int yp = find(y, fa);
        fa[xp] = yp;
    }
}
