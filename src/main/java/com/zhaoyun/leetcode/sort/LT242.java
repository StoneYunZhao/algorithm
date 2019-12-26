package com.zhaoyun.leetcode.sort;

/**
 * 判断两个字符串是否由相同的字母构成
 *
 * @author zhaoyun
 * create at 2019/12/26 19:19
 */
public final class LT242 {
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
                return false;
            }
        }

        return true;
    }
}
