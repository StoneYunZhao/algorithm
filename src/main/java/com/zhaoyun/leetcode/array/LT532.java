package com.zhaoyun.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 在一个数组中，找到所有相差为 k 的元素对组合的个数
 *
 * @author zhaoyun
 * @Date: 2020/2/7
 */
public final class LT532 {

    /**
     * 先排序，后依次计算
     */
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length, c = 0, diff, prei = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(nums[i] == prei) {
                continue;
            }
            prei = nums[i];
            for (int j = i + 1; j < n; j++) {
                diff = nums[j] - nums[i];
                if (diff > k) {
                    break;
                } else if (diff == k) {
                    c++;
                    break;
                }
            }
        }
        return c;
    }

    /**
     * 先存放在 map 中，然后找差值
     */
    public int findPairs2(int[] nums, int k) {
        if (k < 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int c = 0;
        for (int i: map.keySet()) {
            if (k == 0) {
                if (map.get(i) >= 2) {
                    c++;
                }
            } else {
                if (map.containsKey(k + i)) {
                    c++;
                }
            }
        }

        return c;
    }
}
