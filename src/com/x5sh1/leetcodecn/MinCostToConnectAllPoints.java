package com.x5sh1.leetcodecn;

import java.util.PriorityQueue;

/*
https://leetcode-cn.com/problems/min-cost-to-connect-all-points/
Kruskal union find
 */
public class MinCostToConnectAllPoints {
    private int[] roots;
    public int minCostConnectPoints(int[][] points) {
        // sort by distance in all edges
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>((e1, e2) ->  e1.dis - e2.dis);
        int length = points.length;
        roots = new int[length];
        int count = 1;
        for (int i = 0; i < length; i++) {
            roots[i] = i;
            for (int j = i + 1; j < length; j++) {
                Edge edge = new Edge(points, i, j);
                queue.add(edge);
            }
        }
        int result = 0;
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int x = edge.x;
            int y = edge.y;
            int dis = edge.dis;
            // union all connected points
            if (getRoot(x) != getRoot(y)) {
                union(x, y);
                result += dis;
                count++;
            }
            if (count == length) {
                break;
            }
        }

        return result;
    }

    private void union(int x, int y) {
        int rootX = getRoot(x);
        int rootY = getRoot(y);
        if (rootX != rootY) {
            roots[rootX] = roots[rootY];
        }
    }

    private int getRoot(int x) {
        while (x != roots[x]) {
            int tempRoot = roots[x];
            roots[x] = roots[tempRoot];
            x= tempRoot;
        }
        return x;
    }

    class Edge {
        int x;
        int y;
        int dis;

        public Edge(int[][] points, int x, int y) {
            this.x = x;
            this.y = y;
            dis = Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
        }
    }
}
