package com.jane.algorithem.leetcode;

public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int D) {
        int totalWeight = 0, maxWeight = -1;
        for (int weight : weights) {
            totalWeight += weight;
            maxWeight = Math.max(maxWeight, weight);
        }
        int l = maxWeight, r = totalWeight, m;
        int res = Integer.MAX_VALUE;
        while (l <= r) {
            m = l + (r - l) / 2;
            int count = 1;
            int remain = m;
            for (int weight : weights) {
                if (remain >= weight) {
                    remain -= weight;
                } else {
                    remain = m;
                    remain -= weight;
                    count++;
                }
            }
            if (count > D) {
                l = m + 1;
            } else {
                r = m - 1;
                res = Math.min(res, m);
            }
        }
        return res;
    }
}
