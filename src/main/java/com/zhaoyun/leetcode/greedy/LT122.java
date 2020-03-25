package com.zhaoyun.leetcode.greedy;

/**
 * 买卖股票最大利润，可以买卖无数次，一次买卖包括一次买、一次卖
 *
 * @author zhaoyun
 * @Date: 2020/3/18
 */
public final class LT122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int pre = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > pre) {
                profit += prices[i] - pre;
            }
            pre = prices[i];
        }
        return profit;
    }
}
