package com.jane_Plus.algorithem.leetcode;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs_746(int[] cost) {
        int[] path = new int[cost.length+1];
        path[0]=path[1]=0;
        int i = 2;
        while (i < cost.length+1) {
            path[i] = Math.min(path[i-1]+cost[i-1],path[i-2]+cost[i-2]);
            i++;
        }
        return path[cost.length];
    }
}
