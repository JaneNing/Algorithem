package com.jane.algorithem.leetcode;

public class NumberOfSubmatricesThatSumToTarget {

    public static void main(String[] args) {
        NumberOfSubmatricesThatSumToTarget numberOfSubmatricesThatSumToTarget = new NumberOfSubmatricesThatSumToTarget();
        System.out.println(numberOfSubmatricesThatSumToTarget.numSubmatrixSumTarget(new int[][]{{0, 0, 0}}, 0));
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[i][j] = (i == 0 ? 0 : pre[i - 1][j]) + (j == 0 ? 0 : pre[i][j - 1]) - (i == 0 || j == 0 ? 0 : pre[i - 1][j - 1]) + matrix[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    res++;
                }
                if ((i != 0 || j != 0) && pre[i][j] == target) {
                    res++;
                }
                if (i != 0 && j != 0 && pre[i][j] - pre[i - 1][j] == target) {
                    res++;
                }
                if (j != 0 && i != 0 && pre[i][j] - pre[i][j - 1] == target) {
                    res++;
                }
            }
        }
        return res;
    }
}
