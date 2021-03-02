package com.x5sh1.leetcodecn;

/**
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 */
public class RangeSumQuery2DImmutable {
    int[][] matrix;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int col = matrix[0].length;
        this.matrix = new int[row][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.matrix[i][j + 1] = this.matrix[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        if (matrix == null) {
            return sum;
        }
        for (int i = row1; i <= row2; i++) {
            sum += matrix[i][col2 + 1] - matrix[i][col1];
        }
        return sum;
    }
}
