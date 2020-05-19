package com.zhaoyun.leetcode;

/**
 * 楼梯的走法数
 *
 * @author zhaoyun
 * @Date: 2020/3/23
 */
public final class LT70 {

    public int climbStairs(int n) {
        assert n > 0;

        if (n <= 2) {
            return n;
        }

        int ni = 1, nj = 2, sum = -1;
        for (int i = 3; i <= n; i++) {
            sum = ni + nj;
            ni = nj;
            nj = sum;
        }

        return sum;
    }
}
