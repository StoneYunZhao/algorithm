package com.zhaoyun.leetcode;

/**
 * @author zhaoyun
 * @Date: 2020/5/19
 */
public final class LT395 {

    public static void main(String[] args) {
        int longest = new LT395().longestSubstring("bbaaacbd", 3);
        System.out.println(longest);
    }

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k > s.length()) {
            return 0;
        }
        return longest(s.toCharArray(), 0, s.length() - 1, k);
    }

    private int longest(char[] cs, int left, int right, int k) {
        if (right - left + 1 < k) {
            return 0;
        }

        int[] count = new int[26];
        for (int i = left; i <= right; i++) {
            count[cs[i] - 'a']++;
        }

        boolean allk = true;
        int max = 0, l = left;
        for (int i = left; i <= right; i++) {
            if (count[cs[i] - 'a'] < k) {
                max = Math.max(max, longest(cs, l, i - 1, k));
                l = i + 1;
                allk = false;
            }
        }

        return allk ? right - left + 1 : Math.max(max, longest(cs, l, right, k));
    }
}
