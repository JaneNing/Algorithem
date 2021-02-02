package com.x5sh1.leetcodecn;

import java.util.HashMap;
import java.util.Map;

public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] dominoe : dominoes) {
            String key = dominoe[0] > dominoe[1] ? dominoe[1] + "," + dominoe[0] : dominoe[0] + "," + dominoe[1];
            int count = map.getOrDefault(key, 0);
            count++;
            map.put(key, count);
        }

        int result = 0;
        for (String key : map.keySet()) {
            int count = map.get(key);
            if (count > 1) {
                result += helper(count - 1);
            }
        }
        return result;
    }
    private int helper(int i) {
        int result = 1;
        while (i != 1) {
            result += i;
            i--;
        }
        return result;
    }
}
