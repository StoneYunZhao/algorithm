package com.zhaoyun.leetcode.math;

/**
 * 判断正整数的因数是否都为 2 3 5
 *
 * @author zhaoyun
 * @Date: 2020/2/7
 */
public final class LT263 {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        while (num % 2 == 0) {
            num /= 2;
        }

        while (num % 3 == 0) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }
}
