package com.zhaoyun.leetcode.string;

/**
 * 26 进制数转换
 *
 * @author zhaoyun
 * @Date: 2020/1/27
 */
public final class LT171 {
    public int titleToNumber(String s) {
        if (s == null) {
            return -1;
        }

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num *= 26;
            num += s.charAt(i) - 'A' + 1;
        }
        return num;
    }

    public int titleToNumber2(String s) {
        if (s == null) {
            return -1;
        }

        return s.chars().reduce(0, (num, c) -> num * 26 + c - 'A' + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LT171().titleToNumber("AB"));
        System.out.println(new LT171().titleToNumber2("AB"));
    }
}
