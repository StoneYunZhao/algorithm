package com.zhaoyun.leetcode.backtracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * N 皇后问题，输出所有解
 *
 * @author zhaoyun
 * @Date: 2020/3/19
 */
public final class LT51 {
    private int n;
    private List<List<String>> results = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }

        this.n = n;

        int[] result = new int[n];
        Arrays.fill(result, -1);

        backtracking(0, result);

        return results;
    }

    private void backtracking(int row, int[] result) {
        if (row >= n) {
            results.add(getResult(result));
        }

        for (int i = 0; i < n; i++) {
            if (validate(row, i, result)) {
                int [] tmp = result.clone();
                tmp[row] = i;
                backtracking(row + 1, tmp);
            }
        }
    }

    private boolean validate(int row, int i, int[] result) {
        for (int k = row - 1; k >= 0; k--) {
            if (result[k] == i) {
                return false;
            }

            if (result[k] == i + row - k) {
                return false;
            }

            if (result[k] == i - row + k) {
                return false;
            }
        }

        return true;
    }

    private List<String> getResult(int[] result) {
        List<String> r = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char[] cs = new char[n];
            Arrays.fill(cs, '.');
            cs[result[i]] = 'Q';
            r.add(new String(cs));
        }

        return r;
    }
}
