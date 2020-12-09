package com.jane.algorithem.leetcode;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int sum = 0;
        int i = 0, j = 0;
        while (true) {
            for (int k = j; k < matrix[0].length; k++) {
                if (matrix[i][k] != 0) continue;
                j = k;
                matrix[i][k] = ++sum;
                if (sum == n * n) return matrix;
            }
            for (int k = i; k < matrix.length; k++) {
                if (matrix[k][j] != 0) continue;
                i = k;
                matrix[k][j] = ++sum;
                if (sum == n * n) return matrix;
            }
            for (int k = j; k >= 0; k--) {
                if (matrix[i][k] != 0) continue;
                j = k;
                matrix[i][k] = ++sum;
                if (sum == n * n) return matrix;
            }
            for (int k = i; k >= 0; k--) {
                if (matrix[k][j] != 0) continue;
                i = k;
                matrix[k][j] = ++sum;
                if (sum == n * n) return matrix;
            }
        }
    }
}
