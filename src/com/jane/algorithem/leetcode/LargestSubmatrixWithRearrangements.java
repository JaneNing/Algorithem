package com.jane.algorithem.leetcode;

import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {

    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix[i][j] == 1 ? matrix[i - 1][j] + 1 : 0;
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            Arrays.sort(matrix[i]);
            for (int j = n - 1; j >= 0; j--) {
                int height = matrix[i][j];
                res = Math.max(res, height * (n - j));
            }
        }
        return res;
    }
}
