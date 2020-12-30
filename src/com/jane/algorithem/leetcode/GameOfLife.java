package com.jane.algorithem.leetcode;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int height = board.length;
        int width = board[0].length;
        int[][] arr = new int[height][width];
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                if(board[i][j] == 1){
                    board[i][j] = 10;
                }
            }
        }
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                int num = 0;
                if(i != 0 && j != 0){
                    num += (board[i-1][j-1] >= 10 ? 1 : 0);
                }
                if(i != 0){
                    num += (board[i-1][j] >= 10 ? 1 : 0);
                }
                if(j != width -1 && i != 0){
                    num += (board[i-1][j+1] >= 10 ? 1 : 0);
                }
                if(j != 0){
                    num += (board[i][j-1] >= 10 ? 1 : 0);
                }
                if(j != width - 1){
                    num += (board[i][j+1] >= 10 ? 1 : 0);
                }
                if(i != height - 1 && j != 0){
                    num += (board[i+1][j-1] >= 10 ? 1 : 0);
                }
                if(i != height - 1){
                    num += (board[i+1][j] >= 10 ? 1 : 0);
                }
                if(i != height - 1 && j != width - 1){
                    num += (board[i+1][j+1] >= 10 ? 1 : 0);
                }
                if(board[i][j] == 10){
                    if(num < 2 || num > 3){
                        board[i][j] = 10;
                    }else{
                        board[i][j] = 11;
                    }
                }else if(num == 3){
                    board[i][j] = 1;
                }
            }
        }
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                if(board[i][j] == 10){
                    board[i][j] = 0;
                }else if(board[i][j] == 11){
                    board[i][j] = 1;
                }
            }
        }
    }
}
