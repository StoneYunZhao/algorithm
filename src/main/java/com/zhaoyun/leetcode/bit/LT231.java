package com.zhaoyun.leetcode.bit;

/**
 * 判断整数是否为 2 的 n 次方
 *
 * @author zhaoyun
 * @Date: 2020/3/22
 */
public final class LT231 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        int count = 0;
        while (n > 0) {
            if (count > 0) {
                return false;
            }
            count++;
            n = n & (n - 1);
        }

        return true;
    }

}
