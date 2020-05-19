package com.zhaoyun.leetcode;

import java.util.Arrays;

/**
 * 二维字符数组中是否存在某个字符串
 *
 * @author zhaoyun
 * @Date: 2020/3/22
 */
public final class LT79 {
    private int nrow = -1;
    private int ncol = -1;

    private char[] cs = null;
    private int nchar = -1;

    private char[][] board = null;

    public boolean exist(char[][] board, String word) {
        this.board = board;

        nrow = board.length;
        ncol = board[0].length;

        cs = word.toCharArray();
        nchar = cs.length;

        boolean[][] visited = new boolean[nrow][];
        for (int i = 0; i < nrow; i++) {
            boolean[] tmp = new boolean[ncol];
            Arrays.fill(tmp, false);
            visited[i] = tmp;
        }

        char first = cs[0];
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                if (board[i][j] == first) {
                    visited[i][j] = true;
                    if (backtracking(visited, 1, i, j)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean backtracking(boolean[][] visited, int next, int irow, int icol) {
        if (next == nchar) {
            return true;
        }

        // 上
        if (irow > 0 && !visited[irow - 1][icol] && board[irow - 1][icol] == cs[next]) {
            visited[irow - 1][icol] = true;
            if (backtracking(visited, next + 1, irow - 1, icol)) {
                return true;
            }
            visited[irow - 1][icol] = false;
        }

        // 下
        if (irow < nrow - 1 && !visited[irow + 1][icol] && board[irow + 1][icol] == cs[next]) {
            visited[irow + 1][icol] = true;
            if (backtracking(visited, next + 1, irow + 1, icol)) {
                return true;
            }
            visited[irow + 1][icol] = false;
        }

        // 左
        if (icol > 0 && !visited[irow][icol - 1] && board[irow][icol - 1] == cs[next]) {
            visited[irow][icol - 1] = true;
            if (backtracking(visited, next + 1, irow, icol - 1)) {
                return true;
            }
            visited[irow][icol - 1] = false;
        }

        // 右
        if (icol < ncol - 1 && !visited[irow][icol + 1] && board[irow][icol + 1] == cs[next]) {
            visited[irow][icol + 1] = true;
            if (backtracking(visited, next + 1, irow, icol + 1)) {
                return true;
            }
            visited[irow][icol + 1] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] b = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String s = "ABCCED";
        System.out.println(new LT79().exist(b, s));
    }
}
