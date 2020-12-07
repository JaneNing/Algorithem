package com.jane.algorithem.leetcode;

public class ScoreAfterFlippingMatrix {

    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) reverseRow(A, i);
        }
        for (int i = 1; i < A[0].length; i++) {
            if (checkColumn(A, i) > 0) {
                reverseColumn(A, i);
            }
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            int tem = 0;
            for (int j = 0; j < A[i].length; j++) {
                tem = tem << 1;
                tem += A[i][j];
            }
            res += tem;
        }
        return res;
    }

    private void reverseRow(int[][] metric, int i) {
        for (int j = 0; j < metric[i].length; j++) {
            metric[i][j] = 1 - metric[i][j];
        }
    }

    private int checkColumn(int[][] metric, int i) {
        int zero = 0, one = 0;
        for (int j = 0; j < metric.length; j++) {
            if (metric[j][i] == 0) {
                zero++;
            } else {
                one++;
            }
        }
        return zero - one;
    }

    private void reverseColumn(int[][] metric, int i) {
        for (int j = 0; j < metric.length; j++) {
            metric[j][i] = 1 - metric[j][i];
        }
    }
}
