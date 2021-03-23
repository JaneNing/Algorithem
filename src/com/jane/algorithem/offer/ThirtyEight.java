package com.jane.algorithem.offer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ThirtyEight {

    public String[] permutation(String s) {
        Set<String> set = new HashSet<>(2 >> 8);
        Set<Integer> indexSet = new HashSet<>();
        recursion(set, indexSet, s, new StringBuilder());
        String[] res = new String[set.size()];
        Iterator<String> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }

    private void recursion(Set<String> set, Set<Integer> indexSet, String s, StringBuilder builder) {
        if (builder.length() == s.length()) {
            set.add(builder.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (indexSet.contains(i)) continue;
            indexSet.add(i);
            builder.append(s.charAt(i));
            recursion(set, indexSet, s, builder);
            builder.deleteCharAt(builder.length() - 1);
            indexSet.remove(i);
        }
    }
}
