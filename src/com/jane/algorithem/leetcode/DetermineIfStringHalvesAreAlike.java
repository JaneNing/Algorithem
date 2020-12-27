package com.jane.algorithem.leetcode;

import java.util.HashSet;
import java.util.Set;

public class DetermineIfStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        int length = s.length();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int num = 0;
        for (int i = 0; i < length / 2; i++) {
            if (!set.contains(s.charAt(i))) continue;
            num++;
        }
        for (int i = length / 2; i < length; i++) {
            if (!set.contains(s.charAt(i))) continue;
            num--;
        }
        return num == 0;
    }
}
