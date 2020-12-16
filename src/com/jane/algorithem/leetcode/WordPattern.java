package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] array = s.split(" ");
        Set<String> set = new HashSet<>();
        if (array.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s1 = map.get(c);
            if (s1 == null) {
                map.put(c, array[i]);
                if (!set.add(array[i])) {
                    return false;
                }
            } else if (!s1.equals(array[i])) {
                return false;
            }
        }
        return true;
    }
}
