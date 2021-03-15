package com.jane.algorithem.offer;

public class Twelve {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return word.isEmpty();
        int height = board.length;
        int width = board[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean res = recursion(board, word, 0, i, j, new boolean[height][width]);
                if (res) return true;
            }
        }
        return false;
    }

    private boolean recursion(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
        if (word.length() == index) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (board[x][y] != word.charAt(index)) return false;
        if (visited[x][y]) return false;
        visited[x][y] = true;
        boolean res = recursion(board, word, index + 1, x - 1, y, visited);
        if (res) return true;
        res = recursion(board, word, index + 1, x + 1, y, visited);
        if (res) return true;
        res = recursion(board, word, index + 1, x, y - 1, visited);
        if (res) return true;
        res = recursion(board, word, index + 1, x, y + 1, visited);
        if (res) return true;
        visited[x][y] = false;
        return false;
    }
}
