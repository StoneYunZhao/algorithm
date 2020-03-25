package com.zhaoyun.leetcode.dp;

/**
 * 买卖股票最大利润，只能买卖一次，一次买卖包括一次买、一次卖
 *
 * @author zhaoyun
 * @Date: 2020/3/24
 */
public final class LT121 {

    /**
     * 非动态规划解法
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int curMin = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - curMin);
            curMin = Math.min(curMin, prices[i]);
        }
        return max;
    }
}
