package com.zhaoyun.leetcode.dp;

import java.util.Arrays;

/**
 * 最少的硬币凑成总金额
 *
 * @author zhaoyun
 * @Date: 2020/3/29
 */
public final class LT322 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || amount <0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        int[] nums = new int[amount + 1];
        Arrays.fill(nums, -1);

        for (int i = 0; i <= amount; i++) {
            for (int c : coins) {
                if (c == i) {
                    nums[i] = 1;
                    break;
                }

                if (i - c >= 0 && nums[i - c] != -1) {
                    if (nums[i] == -1) {
                        nums[i] = nums[i - c] + 1;
                    } else {
                        nums[i] = Math.min(nums[i - c] + 1, nums[i]);
                    }
                }
            }
        }

        return nums[amount];
    }
}
