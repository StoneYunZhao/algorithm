package com.zhaoyun.leetcode;

/**
 * 数组中最大自序和
 *
 * @author zhaoyun
 * @Date: 2020/4/7
 */
public final class LT53 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length]; // 以 nums[i] 结尾的最大子序和
        dp[0] = nums[0];
        int result = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
