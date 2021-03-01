package com.x5sh1.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3657/
 */
public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int eatable = n / 2;
        Set<Integer> set = new HashSet<>();
        for (int type : candyType) {
            set.add(type);
        }
        return Math.min(set.size(), eatable);
    }
}
