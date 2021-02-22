package com.jane.algorithem.leetcode;

public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int height = matrix.length, width = matrix[0].length;
        for (int i = height - 1; i >= 0; i--) {
            int num = 0;
            for (int j = i; j < height && j - i < width; j++) {
                if (j == i) {
                    num = matrix[j][0];
                } else {
                    if (matrix[j][j - i] != num) return false;
                }
            }
        }
        for (int i = 1; i < width; i++) {
            int num = 0;
            for (int j = i; j < width && j - i < height; j++) {
                if (j == i) {
                    num = matrix[0][j];
                } else {
                    if (matrix[j - i][j] != num) return false;
                }
            }
        }
        return true;
    }
}
