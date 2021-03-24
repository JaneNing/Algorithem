package com.jane.algorithem.offer;

import java.util.HashSet;
import java.util.Set;

public class FortyEight {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, res = 0, ans = 0;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                ans++;
                j++;
                res = Math.max(res, ans);
            } else {
                set.remove(s.charAt(i));
                i++;
                ans--;
            }
        }
        return res;
    }
}
