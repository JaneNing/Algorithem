package com.jane.algorithem.offer;

public class TwentyNine {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int x = 0, y = 0, count = m * n, index = 0;
        int[] res = new int[count];
        while (count != 0) {
            while (count != 0) {
                visited[x][y] = true;
                res[index++] = matrix[x][y];
                count--;
                if (y + 1 < n && !visited[x][y + 1]) {
                    y++;
                } else {
                    x++;
                    break;
                }
            }
            while (count != 0) {
                visited[x][y] = true;
                res[index++] = matrix[x][y];
                count--;
                if (x + 1 < m && !visited[x + 1][y]) {
                    x++;
                } else {
                    y--;
                    break;
                }
            }
            while (count != 0) {
                visited[x][y] = true;
                res[index++] = matrix[x][y];
                count--;
                if (y > 0 && !visited[x][y - 1]) {
                    y--;
                } else {
                    x--;
                    break;
                }
            }
            while (count != 0) {
                visited[x][y] = true;
                res[index++] = matrix[x][y];
                count--;
                if (x > 0 && !visited[x - 1][y]) {
                    x--;
                } else {
                    y++;
                    break;
                }
            }
        }
        return res;
    }
}
