package com.zhaoyun.leetcode;

import java.util.Arrays;

/**
 * 买卖股票最大利润，可以买卖 k 次，一次买卖包括一次买、一次卖
 *
 * @author zhaoyun
 * @Date: 2020/3/25
 */
public final class LT188 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int nday = prices.length;

        if (k > nday / 2) {
            int profit = 0, pre = prices[0];
            for (int i = 1; i < nday; i++) {
                profit += Math.max(0, prices[i] - pre);
                pre = prices[i];
            }
            return profit;
        }

        int nk = k * 2 + 1;
        int[][] profit = new int[nday][nk];

        for (int i = 0; i < nday; i++) {
            int[] tmp = new int[nk];
            Arrays.fill(tmp, 0);
            profit[i] = tmp;

            if (i == 0) {
                for (int j = 0; j < nk; j++) {
                    profit[i][j] = (j & 1) == 1 ? -prices[i] : 0;
                }
                continue;
            }

            for (int j = 0; j < nk; j++) {
                if (j % 2 == 1) {
                    // 处于持有状态
                    int cur = profit[i - 1][j];
                    cur = Math.max(cur, profit[i - 1][j - 1] - prices[i]);

                    profit[i][j] = cur;
                } else {
                    // 处于清仓状态
                    int cur = profit[i - 1][j];
                    if (j - 1 >= 0) {
                        cur = Math.max(cur, profit[i - 1][j - 1] + prices[i]);
                    }
                    profit[i][j] = cur;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int j = 0; j < nk; j++) {
            max = Math.max(max, profit[nday - 1][j]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] p = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0};

        System.out.println(new LT188().maxProfit(4, p));
    }
}
