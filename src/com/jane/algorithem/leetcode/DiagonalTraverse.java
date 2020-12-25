package com.jane.algorithem.leetcode;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[]{};
        int height = matrix.length;
        int width = matrix[0].length;
        int[] res = new int[height * width];
        int index = 0, i = 0, j = 0, reverse = 0;
        while (index != res.length) {
            res[index++] = matrix[i][j];
            if (reverse == 0) {
                if (i == 0 || j == width - 1) {
                    if (j == width - 1) {
                        i++;
                    } else {
                        j++;
                    }
                    reverse = 1 - reverse;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (j == 0 || i == height - 1) {
                    if (i == height - 1) {
                        j++;
                    } else {
                        i++;
                    }
                    reverse = 1 - reverse;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}
