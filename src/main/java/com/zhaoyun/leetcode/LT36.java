package com.zhaoyun.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断数独问题是否有效
 *
 * @author zhaoyun
 * @Date: 2020/3/19
 */
public final class LT36 {

    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rowCache = new Set[9];
        Set<Integer>[] colCache = new Set[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                int index = c - '1';
                if (rowCache[index] == null) {
                    rowCache[index] = new HashSet<>();
                }

                if (colCache[index] == null) {
                    colCache[index] = new HashSet<>();
                }

                if (rowCache[index].contains(i) || colCache[index].contains(j)) {
                    return false;
                }

                int lowi = i / 3 * 3, lowj = j / 3 *3;
                for (int ri = lowi; ri <  lowi + 3; ri++) {
                    for (int rj = lowj; rj < lowj + 3; rj++) {
                        if (ri == i && rj == j) {
                            continue;
                        }
                        if (board[ri][rj] == c) {
                            return false;
                        }
                    }
                }

                rowCache[index].add(i);
                colCache[index].add(j);
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
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(new LT36().isValidSudoku(b));
    }
}
