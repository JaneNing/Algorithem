package com.jane.algorithem.leetcode;

public class RotateImage {

    public void rotate(int[][] matrix) {
        for (int i = 0; i < (matrix.length + 1) / 2; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                int tem = matrix[i][j];
                matrix[i][j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = tem;
                tem = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = tem;
                tem = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = tem;
            }
        }
    }
}
