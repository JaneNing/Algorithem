package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BricksFallingWhenHit {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = grid[i][j];
            }
        }
        for (int i = 0; i < hits.length; i++) {
            int[] hit = hits[i];
            matrix[hit[0]][hit[1]] = 0;
        }
        int[][] fa = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                fa[i][j] = i * n + j;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j != n - 1 && matrix[i][j] == 1 && matrix[i][j + 1] == 1) {
                    union(i, j, i, j + 1, fa);
                }
                if (i != m - 1 && matrix[i][j] == 1 && matrix[i + 1][j] == 1) {
                    union(i, j, i + 1, j, fa);
                }
            }
        }
        Map<Integer, Set<Integer>> bucketMap = new HashMap<>();
        Set<Integer> topSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int bucket = find(i, j, fa);
                Set<Integer> set = bucketMap.computeIfAbsent(bucket, k -> new HashSet<>());
                set.add(i * fa[0].length + j);
                if (i == 0 && matrix[i][j] == 1) {
                    topSet.add(bucket);
                }
            }
        }
        int[] res = new int[hits.length];
        int index = res.length - 1;
        for (int i = hits.length - 1; i >= 0; i--) {
            int row = hits[i][0];
            int col = hits[i][1];
            if (grid[row][col] == 0) {
                index--;
                continue;
            }
            matrix[row][col] = 1;
            boolean left = col != 0 && topSet.contains(find(row, col - 1, fa));
            boolean up = row == 0 || topSet.contains(find(row - 1, col, fa));
            boolean right = col != n - 1 && topSet.contains(find(row, col + 1, fa));
            boolean down = row != m - 1 && topSet.contains(find(row + 1, col, fa));
            if (left || up || right || down) {
                int bucket;
                if (left) {
                    bucket = find(row, col - 1, fa);
                } else if (up) {
                    bucket = row == 0 ? find(row, col, fa) : find(row - 1, col, fa);
                    if (row == 0) {
                        topSet.add(bucket);
                    }
                } else if (right) {
                    bucket = find(row, col + 1, fa);
                } else {
                    bucket = find(row + 1, col, fa);
                }
                fa[row][col] = bucket;
                if (col != 0 && matrix[row][col - 1] == 1 && !topSet.contains(find(row, col - 1, fa))) {
                    Set<Integer> set = bucketMap.get(find(row, col - 1, fa));
                    res[index] += set.size();
                    for (Integer integer : set) {
                        union(integer / n, integer % n, row, col, fa);
                    }
                    set.clear();
                }
                if (col != n - 1 && matrix[row][col + 1] == 1 && !topSet.contains(find(row, col + 1, fa))) {
                    Set<Integer> set = bucketMap.get(find(row, col + 1, fa));
                    res[index] += set.size();
                    for (Integer integer : set) {
                        union(integer / n, integer % n, row, col, fa);
                    }
                    set.clear();
                }
                if (row != 0 && matrix[row - 1][col] == 1 && !topSet.contains(find(row - 1, col, fa))) {
                    Set<Integer> set = bucketMap.get(find(row - 1, col, fa));
                    res[index] += set.size();
                    for (Integer integer : set) {
                        union(integer / n, integer % n, row, col, fa);
                    }
                    set.clear();
                }
                if (row != m - 1 && matrix[row + 1][col] == 1 && !topSet.contains(find(row + 1, col, fa))) {
                    Set<Integer> set = bucketMap.get(find(row + 1, col, fa));
                    res[index] += set.size();
                    for (Integer integer : set) {
                        union(integer / n, integer % n, row, col, fa);
                    }
                    set.clear();
                }
            } else {
                if (col != 0 && matrix[row][col - 1] == 1 && !topSet.contains(find(row, col - 1, fa)) && find(row, col, fa) != find(row, col - 1, fa)) {
                    Set<Integer> set = bucketMap.get(find(row, col - 1, fa));
                    for (Integer integer : set) {
                        union(integer / n, integer % n, row, col, fa);
                    }
                    bucketMap.get(find(row, col, fa)).addAll(set);
                    set.clear();
                }
                if (col != n - 1 && matrix[row][col + 1] == 1 && !topSet.contains(find(row, col + 1, fa)) && find(row, col, fa) != find(row, col + 1, fa)) {
                    Set<Integer> set = bucketMap.get(find(row, col + 1, fa));
                    for (Integer integer : set) {
                        union(integer / n, integer % n, row, col, fa);
                    }
                    bucketMap.get(find(row, col, fa)).addAll(set);
                    set.clear();
                }
                if (row != 0 && matrix[row - 1][col] == 1 && !topSet.contains(find(row - 1, col, fa)) && find(row, col, fa) != find(row - 1, col, fa)) {
                    Set<Integer> set = bucketMap.get(find(row - 1, col, fa));
                    for (Integer integer : set) {
                        union(integer / n, integer % n, row, col, fa);
                    }
                    bucketMap.get(find(row, col, fa)).addAll(set);
                    set.clear();
                }
                if (row != m - 1 && matrix[row + 1][col] == 1 && !topSet.contains(find(row + 1, col, fa)) && find(row, col, fa) != find(row + 1, col, fa)) {
                    Set<Integer> set = bucketMap.get(find(row + 1, col, fa));
                    for (Integer integer : set) {
                        union(integer / n, integer % n, row, col, fa);
                    }
                    bucketMap.get(find(row, col, fa)).addAll(set);
                    set.clear();
                }
            }
            index--;
        }
        return res;
    }

    private int find(int x, int y, int[][] fa) {
        if (x * fa[0].length + y == fa[x][y]) {
            return fa[x][y];
        } else {
            int pa = find(fa[x][y] / fa[0].length, fa[x][y] % fa[0].length, fa);
            fa[x][y] = pa;
            return pa;
        }
    }

    private void union(int x1, int y1, int x2, int y2, int[][] fa) {
        int xp = find(x1, y1, fa);
        int yp = find(x2, y2, fa);
        fa[xp / fa[0].length][xp % fa[0].length] = yp;
    }
}
