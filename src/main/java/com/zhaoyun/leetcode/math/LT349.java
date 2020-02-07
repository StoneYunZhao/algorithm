package com.zhaoyun.leetcode.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 两个数组求交集，重复的显示一次
 *
 * @author zhaoyun
 * @Date: 2020/2/6
 */
public final class LT349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> c = new HashMap<>();
        Set<Integer> res = new HashSet<>();

        for (int i : nums1) {
            c.put(i, 1);
        }

        for (int i : nums2) {
            if (c.get(i) != null) {
                res.add(i);
            }
        }

        int n = res.size();
        int[] r = new int[n];
        int i = 0;
        for (int j : res) {
            r[i++] = j;
        }
        return r;
    }
}

