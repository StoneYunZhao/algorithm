package com.zhaoyun.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 两个数组求交集，重复的显示多次
 *
 * @author zhaoyun
 * @Date: 2020/2/7
 */
public final class LT350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums2) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> res = new LinkedList<>();
        for (int i: nums1) {
            Integer v = map.get(i);
            if (v != null && v > 0) {
                res.add(i);
                map.put(i, v - 1);
            }
        }

        int[] r = new int[res.size()];
        int cur = 0;
        for (int i: res) {
            r[cur++] = i;
        }
        return r;
    }
}
