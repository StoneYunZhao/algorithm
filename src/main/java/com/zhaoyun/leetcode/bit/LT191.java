package com.zhaoyun.leetcode.bit;

/**
 * 计算二进制数有几个 1
 *
 * @author zhaoyun
 * @Date: 2020/3/22
 */
public final class LT191 {
    public int hammingWeight(int n) {
        int c = 0;
        while (n != 0) {
            n= n & (n - 1);
            c++;
        }
        return c;
    }
}
