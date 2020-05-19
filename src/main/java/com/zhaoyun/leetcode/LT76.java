package com.zhaoyun.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoyun
 * @Date: 2020/5/11
 */
public final class LT76 {

    public static void main(String[] args) {
        String min = new LT76().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(min);
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, 1 + need.getOrDefault(c, 0));
        }

        char[] cs = s.toCharArray();
        int lens = cs.length, lent = t.length();

        int left = 0, right = 0, valid = 0, minIndex = -1, minLen = -1;
        while (right < lens) {
            char c = cs[right];
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c)) {
                if (window.get(c) <= need.get(c)) {
                    valid++;
                }

                // remove
                while (valid == lent) {
                    if (minIndex == -1 || right - left + 1 < minLen) {
                        minIndex = left;
                        minLen = right - left + 1;
                    }

                    char remove = cs[left];
                    if (!need.containsKey(remove) || need.get(remove) <= window.get(remove)) {
                        if(need.containsKey(remove) && need.get(remove) >= window.get(remove)) {
                            valid--;
                        }

                        window.put(remove, window.get(remove) - 1);
                        left++;
                    }
                }
            }

            right++;
        }

        return minIndex == -1 ? "" : new String(cs, minIndex, minLen);
    }

}
