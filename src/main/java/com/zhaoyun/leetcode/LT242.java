package com.zhaoyun.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断两个字符串是否由相同的字母构成
 *
 * @author zhaoyun
 * create at 2019/12/26 19:19
 */
public final class LT242 {

    /**
     * 通过自己实现简单的 HashMap
     */
    public boolean isAnagram(String s, String t) {
        int ns = s.length();
        int nt = t.length();
        if (ns != nt) return false;

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        int[] is = new int[26];
        int i, index;
        for (i = 0; i < ns; i++) {
            index = cs[i] - 'a';
            is[index] = is[index] + 1;
        }

        for (i = 0; i < nt; i++) {
            index = ct[i] - 'a';
            is[index] = is[index] - 1;
            if(is[index] < 0) {
                // 若不匹配，一定会出现小于 0 的情况，因为前面已经判断两个字符串长度是一致的
                return false;
            }
        }

        return true;
    }

    /**
     * 通过使用核心库的 HashMap
     */
    public boolean isAnagram2(String s, String t) {
        if (s == null) {
            return t == null;
        }

        Map<Character, Integer> map = new HashMap<>();

        char[] cs = s.toCharArray();
        for (char c: cs) {
            int cur = map.getOrDefault(c, 0);
            map.put(c, ++cur);
        }

        char[] ct = t.toCharArray();
        for (char c: ct) {
            Integer cur = map.get(c);
            if(cur == null) {
                return false;
            }
            if (--cur == 0) {
                map.remove(c);
            } else {
                map.put(c, cur);
            }
        }

        return map.isEmpty();

    }
}
