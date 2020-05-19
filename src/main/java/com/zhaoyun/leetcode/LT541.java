package com.zhaoyun.leetcode;

/**
 * 一个字符串，每隔 2k 个字符，前面 k 个字符反转，后面 k 个字符保持原来的顺序
 *
 * @author zhaoyun
 * @Date: 2020/2/8
 */
public final class LT541 {

    public String reverseStr(String s, int k) {
        if (s == null || k <= 1) return s;

        StringBuilder res = new StringBuilder();

        boolean reverse = true;
        int cur = 0, index = 0;
        for (char c: s.toCharArray()) {
            if (cur == k) {
                cur = 0;
                reverse = !reverse;
                index += k;
            }

            if (reverse) {
                res.insert(index, c);
            } else {
                res.append(c);
            }
            cur++;
        }

        return res.toString();
    }
}
