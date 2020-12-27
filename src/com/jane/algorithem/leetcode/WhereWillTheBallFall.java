package com.jane.algorithem.leetcode;

public class WhereWillTheBallFall {

    public int[] findBall(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[] res = new int[width];
        for (int i = 0; i < width; i++) {
            int col = i;
            for (int j = 0; j < height; j++) {
                if (col == 0 && grid[j][col] == -1) {
                    res[i] = -1;
                    break;
                }
                if (col == width - 1 && grid[j][col] == 1) {
                    res[i] = -1;
                    break;
                }
                if (grid[j][col] == 1) {
                    if (grid[j][col + 1] == -1) {
                        res[i] = -1;
                        break;
                    } else {
                        col++;
                    }
                } else {
                    if (grid[j][col - 1] == 1) {
                        res[i] = -1;
                        break;
                    } else {
                        col--;
                    }
                }
                if (j == height - 1) {
                    res[i] = col;
                }
            }
        }
        return res;
    }
}
