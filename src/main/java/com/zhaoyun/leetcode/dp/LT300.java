package com.zhaoyun.leetcode.dp;

/**
 * 最长上升子序列
 *
 * @author zhaoyun
 * @Date: 2020/3/25
 */
public final class LT300 {

    /**
     * 动态规划方法
     *
     * 状态 max[i] : 第 i 个元素被选中时，nums[0:i] 的最长子序列
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] max = new int[n];

        int global = 0;
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    tmp = Math.max(max[j], tmp);
                }
            }
            max[i] = ++tmp;
            global = Math.max(global, max[i]);
        }
        return global;
    }
}
