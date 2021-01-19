package com.x5sh1.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3607/
 */
public class CountSortedVowelStrings {
    private int result = 0;

    public int countVowelStrings(int n) {
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        helper(vowel, new ArrayList<Character>(), n, 'b');
        return result;
    }

    private void helper(char[] vowel, List<Character> list, int n, char last) {
        if (list.size() == n) {
            result++;
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (last == 'b' || vowel[i] >= last) {
                list.add(vowel[i]);
                helper(vowel, list, n, vowel[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}
