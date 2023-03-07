package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (List<Integer> integers : wall) {
            int sum = 0;
            for (Integer integer : integers) {
                sum += integer;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                maxLen = Math.max(maxLen, sum);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int res = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getKey() == maxLen) continue;
            res = Math.max(res, entry.getValue());
        }
        return wall.size() - res;
    }
}
