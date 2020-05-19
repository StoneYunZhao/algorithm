package com.zhaoyun.leetcode;

/**
 * 逆转字符串
 *
 * @author zhaoyun
 * @Date: 2020/2/11
 */
public final class LT344 {
    public void reverseString(char[] s) {
        if (s == null) return;
        int n = s.length;
        int i = 0, j = n - 1;

        while (i < j) {
            char tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
    }
}
