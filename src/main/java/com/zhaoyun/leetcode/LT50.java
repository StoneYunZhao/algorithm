package com.zhaoyun.leetcode;

/**
 * 求 x 的 n 次方
 *
 * @author zhaoyun
 * @Date: 2020/3/18
 */
public final class LT50 {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (x == 0.0) {
            return x;
        }

        if (n == -1) {
            return 1.0 / x;
        }

        double tmp = myPow(x * x,n / 2);
        return n % 2 == 0 ? tmp : (n < 0 ? 1.0 / x : x) * tmp;
    }
}
