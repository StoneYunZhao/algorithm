package com.zhaoyun.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 查找没有重复字符的最长子串
 * Created by ZhaoYun on 2019-06-20
 **/
public final class LT03 {
    public int lengthOfLongestSubstring(String s) {
        int first = 0, cur = 0, max = 0;
        Map<Character, Integer> data = new HashMap<>();

        for (char c: s.toCharArray()) {
            if (data.containsKey(c)) {
                max = Math.max(max, cur - first);
                first = Math.max(data.get(c) + 1, first);
            }
            data.put(c, cur++);
        }

        return Math.max(max, cur - first);
    }
}
