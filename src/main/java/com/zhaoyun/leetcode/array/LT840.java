package com.zhaoyun.leetcode.array;

/**
 * 判断矩阵中有多少个魔法方阵
 *
 * @author zhaoyun
 * @Date: 2020/2/7
 */
public final class LT840 {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (n < 3 || m < 3) {
            return 0;
        }

        int c = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (isMagic(grid, i, j)) {
                    c++;
                }
            }
        }

        return c;
    }

    private boolean isMagic(int[][] grid, int n, int m) {
        int sum = grid[n][m] + grid[n + 1][m + 1] + grid[n + 2][m + 2];
        if (grid[n][m + 2] + grid[n + 1][m + 1] + grid[n + 2][m] != sum) {
            return false;
        }

        int[] nums = new int[9];

        for (int i = 0; i < 3; i++) {
            if (grid[n + i][m] + grid[n + i][m + 1] + grid[n + i][m + 2] != sum) {
                return false;
            }

            if (grid[n][m + i] + grid[n + 1][m + i] + grid[n + 2][m + i] != sum) {
                return false;
            }

            if (grid[n + i][m] < 1 || grid[n + i][m] > 9) {
                return false;
            }
            if (grid[n + i][m + 1] < 1 || grid[n + i][m + 1] > 9) {
                return false;
            }
            if (grid[n + i][m + 2] < 1 || grid[n + i][m + 2] > 9) {
                return false;
            }
            nums[grid[n + i][m] - 1]++;
            nums[grid[n + i][m + 1] - 1]++;
            nums[grid[n + i][m + 2] - 1]++;
        }

        for (int i = 0; i < 9; i++) {
            if (nums[i] != 1) {
                return false;
            }
        }

        return true;
    }
}
