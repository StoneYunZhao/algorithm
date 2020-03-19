package com.zhaoyun.leetcode.backtracking;

import com.zhaoyun.leetcode.map.LT36;

import java.util.Arrays;

/**
 * 找数独的解
 *
 * @author zhaoyun
 * @Date: 2020/3/19
 */
public final class LT37 {

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        if (row > 8) {
            return true;
        }

        int nextRow = row, nextCol = col;
        if (col == 8) {
            nextRow++;
            nextCol = 0;
        } else {
            nextCol++;
        }

        char c = board[row][col];
        if (c != '.') {
            return solve(board, nextRow, nextCol);
        }

        for (int i = 0; i < 9; i++) {
            char cur = (char) ('1' + i);

            if (!validate(board, row, col, cur)) {
                continue;
            }

            board[row][col] = cur;
            if (solve(board, nextRow, nextCol)) {
                return true;
            }

            board[row][col] = '.';

        }

        return false;
    }

    private boolean validate(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }

            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] b = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new LT37().solveSudoku(b);

        System.out.println(new LT36().isValidSudoku(b));
        System.out.println(Arrays.deepToString(b));
    }
}
