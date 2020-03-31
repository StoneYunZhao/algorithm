package com.zhaoyun.leetcode.array;

import java.util.Arrays;

/**
 * 数组中找到没有出现的最小正整数
 *
 * @author zhaoyun
 * @Date: 2020/3/31
 */
public final class LT42 {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        Arrays.sort(nums);

        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            if (nums[i] > res) {
                break;
            }

            res++;

            while (i < nums.length - 1 && nums[i + 1] == res - 1) {
                i++;
            }

        }
        return res;
    }
}
