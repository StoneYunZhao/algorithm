package com.zhaoyun.leetcode.bit;

/**
 * 计算 0 到 n 的每个数的二进制表示中 1 的个数
 *
 * @author zhaoyun
 * @Date: 2020/3/22
 */
public final class LT338 {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }

        return res;
    }
}
