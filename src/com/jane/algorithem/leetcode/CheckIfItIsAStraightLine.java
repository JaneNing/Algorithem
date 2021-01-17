package com.jane.algorithem.leetcode;

public class CheckIfItIsAStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 1; i < coordinates.length; i++) {
            coordinates[i][0] -= coordinates[0][0];
            coordinates[i][1] -= coordinates[0][1];
        }
        for (int i = 2; i < coordinates.length; i++) {
            if (coordinates[i][0] * coordinates[1][1] - coordinates[i][1] * coordinates[1][0] != 0) return false;
        }
        return true;
    }
}
