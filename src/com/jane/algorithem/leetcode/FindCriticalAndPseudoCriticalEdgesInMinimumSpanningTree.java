package com.jane.algorithem.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int len = edges.length;
        int[][] newEdges = new int[len][4];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, Comparator.comparingInt(i -> i[2]));
        int value = 0;
        int[] fa = new int[n];
        init(fa);
        for (int i = 0; i < len; i++) {
            int i1 = find(newEdges[i][0], fa);
            int i2 = find(newEdges[i][1], fa);
            if (i1 != i2) {
                value += newEdges[i][2];
                union(newEdges[i][0], newEdges[i][1], fa);
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        lists.add(new ArrayList<>());
        for (int i = 0; i < len; i++) {
            init(fa);
            int v = 0;
            int count = n;
            for (int j = 0; j < len; j++) {
                if (i != j && (find(newEdges[j][0], fa) != find(newEdges[j][1], fa))) {
                    union(newEdges[j][0], newEdges[j][1], fa);
                    v += newEdges[j][2];
                    count--;
                }
            }
            if (count != 1 || v > value) {
                lists.get(0).add(newEdges[i][3]);
                continue;
            }
            init(fa);
            union(newEdges[i][0], newEdges[i][1], fa);
            v = newEdges[i][2];
            for (int j = 0; j < len; j++) {
                if (i != j && (find(newEdges[j][0], fa) != find(newEdges[j][1], fa))) {
                    union(newEdges[j][0], newEdges[j][1], fa);
                    v += newEdges[j][2];
                }
            }
            if (v == value) {
                lists.get(1).add(newEdges[i][3]);
            }
        }
        return lists;
    }

    private void init(int[] fa) {
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
    }

    private int find(int x, int[] fa) {
        if (x == fa[x]) {
            return x;
        } else {
            int pa = find(fa[x], fa);
            fa[x] = pa;
            return pa;
        }
    }

    private void union(int x, int y, int[] fa) {
        int px = find(x, fa);
        int py = find(y, fa);
        fa[px] = py;
    }
}
