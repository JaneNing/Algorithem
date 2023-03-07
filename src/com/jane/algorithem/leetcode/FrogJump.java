package com.jane.algorithem.leetcode;

public class FrogJump {

    public boolean canCross(int[] stones) {
        int n = stones.length;
        if (n == 0) return true;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int dis = stones[i] - stones[j];
                if (dis >= 0 && dis < n) {
                    visited[i][dis] = (dis - 1 >= 0 && dis - 1 < n && visited[j][dis - 1]) ||
                            (visited[j][dis]) ||
                            (dis + 1 < n && visited[j][dis + 1]);
                    if (i == n - 1 && visited[i][dis]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
