package com.zhaoyun.leetcode.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author zhaoyun
 * @Date: 2020/3/17
 */
public final class LT01 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = cache.get(target - nums[i]);
            if (j != null) {
                return new int[]{i, j};
            }
            cache.put(nums[i], i);
        }

        return new int[0];
    }
}
