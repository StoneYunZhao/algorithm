package com.zhaoyun.leetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * N 皇后问题，输出解的个数
 *
 * @author zhaoyun
 * @Date: 2020/3/19
 */
public final class LT52 {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return n;
        }

        return backtracking(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int backtracking(int n, int row, Set<Integer> cols, Set<Integer> left, Set<Integer> right) {
        if (row >= n) {
            return 1;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (cols.contains(i) || left.contains(i - row) || right.contains(i + row)) {
                continue;
            }

            cols.add(i);
            left.add(i - row);
            right.add(i + row);

            sum += backtracking(n, row + 1, cols, left, right);

            cols.remove(i);
            left.remove(i - row);
            right.remove(i + row);
        }

        return sum;
    }

}
