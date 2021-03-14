package com.jane.algorithem.offer;

public class Fourth {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;
        int height = matrix.length, width = matrix[0].length, x = 0, y = width - 1;
        while (x >= 0 && x < height && y >= 0 && y < width) {
            if (matrix[x][y] == target) return true;
            else if (matrix[x][y] < target) x++;
            else y--;
        }
        return false;
    }
}
