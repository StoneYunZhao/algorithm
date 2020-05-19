package com.zhaoyun.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 二维字符数组中找出存在的字符串
 *
 * @author zhaoyun
 * @Date: 2020/3/22
 */
public final class LT212 {
    private int nrow = -1;
    private int ncol = -1;

    Set<String> res = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || words == null || board.length < 1) {
            return Collections.emptyList();
        }

        this.nrow = board.length;
        this.ncol = board[0].length;

        for (String word: words) {
            for (int i = 0; i < nrow; i++) {
                assert board[i].length == ncol;
                for (int j = 0; j < ncol; j++) {
                    backtracking(board, word, i, j, 0);
                }
            }
        }

        return new ArrayList<>(res);
    }

    private void backtracking(char[][] board, String word, int irow, int icol, int cur) {
        if (irow < 0 || icol < 0 || irow >= nrow || icol >= ncol || cur >= word.length()) {
            return;
        }

        if (board[irow][icol] != word.charAt(cur)) {
            return;
        }

        if (cur == word.length() - 1) {
            res.add(word);
            return;
        }

        char tmp = board[irow][icol];
        board[irow][icol] = '#';

        backtracking(board, word, irow - 1, icol, cur + 1);
        backtracking(board, word, irow + 1, icol, cur + 1);
        backtracking(board, word, irow, icol - 1, cur + 1);
        backtracking(board, word, irow, icol + 1, cur + 1);

        board[irow][icol] = tmp;
    }
}
