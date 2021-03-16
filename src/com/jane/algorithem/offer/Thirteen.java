package com.jane.algorithem.offer;

public class Thirteen {

    public int movingCount(int m, int n, int k) {
        boolean[][] reach = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cal(i) + cal(j) <= k) reach[i][j] = true;
            }
        }
        return dfs(reach, 0, 0, m, n, new boolean[m][n]);
    }

    private int dfs(boolean[][] reach, int x, int y, int m, int n, boolean[][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n) return 0;
        if (!reach[x][y]) return 0;
        if (visited[x][y]) return 0;
        visited[x][y] = true;
        return 1 + dfs(reach, x - 1, y, m, n, visited) + dfs(reach, x + 1, y, m, n, visited) +
                dfs(reach, x, y - 1, m, n, visited) + dfs(reach, x, y + 1, m, n, visited);
    }

    private int cal(int num) {
        int res = 0;
        while (num != 0) {
            res += (num % 10);
            num /= 10;
        }
        return res;
    }
}
