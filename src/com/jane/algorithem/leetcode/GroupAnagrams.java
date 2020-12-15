package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                arr[c - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                builder.append(arr[i]).append("-");
            }
            List<String> list = map.computeIfAbsent(builder.toString(), k -> new ArrayList<>());
            list.add(str);
        }
        Collection<List<String>> collection = map.values();
        return new ArrayList<>(collection);
    }
}